package moe.crx.frontend;

import com.google.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Feature;
import jakarta.ws.rs.core.FeatureContext;
import jakarta.ws.rs.core.MediaType;
import moe.crx.core.ConfigurationFactory;
import moe.crx.dao.BoardDao;
import moe.crx.dto.APIError;
import moe.crx.html.pages.BoardPage;
import moe.crx.core.Configuration;
import moe.crx.html.pages.MessagePage;
import org.jetbrains.annotations.NotNull;

@Path("/{boardTag}")
@Singleton
public final class BoardFrontend implements Feature {

    private final Configuration config;
    private final BoardDao boardDao;

    @Inject
    public BoardFrontend(@NotNull ConfigurationFactory configurationFactory,
                         @NotNull BoardDao boardDao) {
        this.config = configurationFactory.getInstance();
        this.boardDao = boardDao;
    }

    @Override
    public boolean configure(FeatureContext context) {
        return true;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String board(@PathParam("boardTag") String boardTag) {
        var board = boardDao.readByTag(boardTag);

        if (board == null) {
            return new MessagePage(config)
                    .consumeResponse(new APIError(0, "Specified board doesn't exist."))
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
