package moe.crx.frontend;

import com.google.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Feature;
import jakarta.ws.rs.core.FeatureContext;
import jakarta.ws.rs.core.MediaType;
import moe.crx.api.BoardsApi;
import moe.crx.core.ConfigurationFactory;
import moe.crx.dto.APIError;
import moe.crx.html.pages.BoardPage;
import moe.crx.core.Configuration;
import moe.crx.html.pages.MessagePage;
import org.jetbrains.annotations.NotNull;

@Path("/{boardTag}")
@Singleton
public final class BoardFrontend implements Feature {

    private final Configuration config;
    private final BoardsApi boardsApi;

    @Inject
    public BoardFrontend(@NotNull ConfigurationFactory configurationFactory,
                         @NotNull BoardsApi boardsApi) {
        this.config = configurationFactory.getInstance();
        this.boardsApi = boardsApi;
    }

    @Override
    public boolean configure(FeatureContext context) {
        return true;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String board(@PathParam("boardTag") String boardTag) {
        var board = boardsApi.getBoardByTag(boardTag);

        if (board instanceof APIError error) {
            return new MessagePage(config)
                    .consumeResponse(error)
                    .html();
        }

        return new BoardPage(config)
                .html();
    }

    @GET
    @Path("/{threadId}")
    @Produces(MediaType.TEXT_HTML)
    public String thread(@PathParam("threadId") long threadId) {
        return new BoardPage(config)
                .html();
    }
}
