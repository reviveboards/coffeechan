package moe.crx.frontend;

import com.google.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Feature;
import jakarta.ws.rs.core.FeatureContext;
import jakarta.ws.rs.core.MediaType;
import moe.crx.core.ConfigurationFactory;
import moe.crx.html.pages.BoardPage;
import moe.crx.core.Configuration;
import org.jetbrains.annotations.NotNull;

@Path("/{boardTag}")
@Singleton
public final class BoardFrontend implements Feature {

    private final Configuration config;

    @Inject
    public BoardFrontend(@NotNull ConfigurationFactory configurationFactory) {
        this.config = configurationFactory.getInstance();
    }

    @Override
    public boolean configure(FeatureContext context) {
        return true;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String board(@PathParam("boardTag") String boardTag) {
        var boardPage = new BoardPage().consumeConfig(config);

        return boardPage.html();
    }

    @GET
    @Path("/{threadId}")
    @Produces(MediaType.TEXT_HTML)
    public String thread(@PathParam("threadId") long threadId) {
        var boardPage = new BoardPage().consumeConfig(config);

        return boardPage.html();
    }
}
