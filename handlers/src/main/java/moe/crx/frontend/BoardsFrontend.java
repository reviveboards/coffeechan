package moe.crx.frontend;

import com.google.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.*;
import moe.crx.dao.BoardDao;
import moe.crx.frontend.html.pages.BoardsPage;
import org.jetbrains.annotations.NotNull;

import static moe.crx.handlers.Responser.ok;

@Path("/boards")
@Singleton
public final class BoardsFrontend implements Feature {

    private final BoardDao boardDao;

    @Inject
    public BoardsFrontend(@NotNull BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    @Override
    public boolean configure(FeatureContext context) {
        return true;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response boards() {
        var boardsPage = new BoardsPage().consumeBoards(boardDao.all());

        return ok(boardsPage.html());
    }
}
