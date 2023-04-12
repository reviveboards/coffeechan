package moe.crx.frontend;

import jakarta.inject.Singleton;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Feature;
import jakarta.ws.rs.core.FeatureContext;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import moe.crx.frontend.html.pages.BoardPage;

import static moe.crx.handlers.Responser.ok;

@Path("/{boardTag}")
@Singleton
public final class BoardFrontend implements Feature {

    @Override
    public boolean configure(FeatureContext context) {
        return true;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response board(@PathParam("boardTag") String boardTag) {
        var boardPage = new BoardPage();

        return ok(boardPage.html());
    }

    @GET
    @Path("/{threadId}")
    @Produces(MediaType.TEXT_HTML)
    public Response thread(@PathParam("threadId") long threadId) {
        var boardPage = new BoardPage();

        return ok(boardPage.html());
    }
}
