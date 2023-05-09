package moe.crx.frontend.html.pages;

import moe.crx.dto.Board;
import moe.crx.frontend.html.components.BoardList;
import org.jetbrains.annotations.NotNull;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import java.util.List;

public final class BoardsPage extends AbstractPage<BoardsPage> {

    private static final Element BASE;

    static {
        try {
            BASE = Jsoup.parse(BoardList.class.getResourceAsStream("/frontend/pages/boards.html"), "UTF-8", "");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public BoardsPage() {
        super(BASE);
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