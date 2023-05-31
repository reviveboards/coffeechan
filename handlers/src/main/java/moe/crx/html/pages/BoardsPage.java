package moe.crx.html.pages;

import moe.crx.core.Configuration;
import moe.crx.dao.BoardDao;
import moe.crx.dao.CategoryDao;
import moe.crx.html.components.BoardListCard;
import org.jetbrains.annotations.NotNull;

public final class BoardsPage extends AbstractPage<BoardsPage> {

    public BoardsPage(@NotNull Configuration config) {
        super("/frontend/pages/boards.html", config);
    }

    public @NotNull BoardsPage consumeBoards(@NotNull CategoryDao categoryDao, @NotNull BoardDao boardDao) {
        var boardList = new BoardListCard().consumeBoards(categoryDao, boardDao).getElement();

        getElement().getElementsByClass("coffeechan#boardListCard").forEach(element ->
                element.appendChild(boardList));

        return this;
    }
}
