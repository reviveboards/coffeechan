package moe.crx.frontend.html.pages;

import moe.crx.dto.Board;
import moe.crx.frontend.html.components.BoardList;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public final class BoardsPage extends AbstractPage<BoardsPage> {

    public BoardsPage() {
        super("/frontend/pages/boards.html");
    }

    public @NotNull BoardsPage consumeBoardList(@NotNull BoardList boardList) {
        getElement().getElementsByClass("coffeechan#boardList").forEach(element ->
                element.appendChild(boardList.getElement()));

        return this;
    }

    public @NotNull BoardsPage consumeBoards(@NotNull List<Board> boards) {
        return consumeBoardList(new BoardList().consumeBoards(boards));
    }
}
