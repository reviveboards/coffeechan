package moe.crx.frontend;

import com.google.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.*;
import moe.crx.dao.BoardDao;
import org.jetbrains.annotations.NotNull;
import org.jsoup.Jsoup;

import java.io.IOException;

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
    public Response boards(@Context UriInfo uriInfo) throws IOException {
        var boardsPage = Jsoup.parse(getClass().getResourceAsStream("/frontend/boards.html"), "UTF-8", uriInfo.getAbsolutePath().toString());
        var boardComponent = Jsoup.parse(getClass().getResourceAsStream("/frontend/components/board.html"), "UTF-8", uriInfo.getAbsolutePath().toString()).child(0);

        var boards = boardDao.all();
        var boardsElements = boardsPage.getElementsByClass("coffeechan#boards");
        for (var board : boards) {
            var newComponent = boardComponent.clone();

            newComponent.getElementsByClass("abc").forEach((boardLink) ->
                    boardLink.attr("href", uriInfo.getAbsolutePath().toString() + "/" + board.getTag()));
            newComponent.getElementsByClass("abc").forEach((boardName) ->
                    boardName.append(board.getName()));

            boardsElements.forEach((boardsElement) ->
                    boardsElement.appendChild(newComponent));
        }

        boardsPage.getElementsByClass("coffeechan#title").forEach((boardName) ->
                boardName.append("/nnchan"));

        return ok(boardsPage.html());
    }
}
