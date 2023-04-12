package moe.crx.frontend;

import com.google.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Feature;
import jakarta.ws.rs.core.FeatureContext;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import moe.crx.core.ConfigurationFactory;
import moe.crx.frontend.html.pages.BoardPage;
import moe.crx.core.Configuration;
import org.jetbrains.annotations.NotNull;

import static moe.crx.handlers.Responser.ok;

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
    public Response board(@PathParam("boardTag") String boardTag) {
        var boardPage = new BoardPage().consumeConfig(config);

        return ok(boardPage.html());
    }

    @GET
    @Path("/{threadId}")
    @Produces(MediaType.TEXT_HTML)
    public Response thread(@PathParam("threadId") long threadId) {
        var boardPage = new BoardPage().consumeConfig(config);

        return ok(boardPage.html());
    }
}
