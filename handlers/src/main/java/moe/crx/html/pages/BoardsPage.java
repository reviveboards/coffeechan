package moe.crx.html.pages;

import moe.crx.api.BoardsApi;
import moe.crx.api.CategoriesApi;
import moe.crx.core.Configuration;
import moe.crx.html.components.BoardListCard;
import org.jetbrains.annotations.NotNull;

public final class BoardsPage extends AbstractPage<BoardsPage> {

    public BoardsPage(@NotNull Configuration config) {
        super("/frontend/pages/boards.html", config);
    }

    public @NotNull BoardsPage consumeBoards(@NotNull CategoriesApi categoriesApi, @NotNull BoardsApi boardsApi) {
        var boardList = new BoardListCard().consumeBoards(categoriesApi, boardsApi).getElement();

        getElement().getElementsByClass("coffeechan#boardListCard").forEach(element ->
                element.appendChild(boardList));

        return this;
    }
}
