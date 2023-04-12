package moe.crx.frontend.html.components;

import moe.crx.dto.Board;
import moe.crx.frontend.html.AbstractComponent;
import org.jetbrains.annotations.NotNull;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import java.util.List;

public final class BoardList extends AbstractComponent<BoardList> {

    private static final Element BASE;

    static {
        try {
            BASE = Jsoup.parse(BoardList.class.getResourceAsStream("/frontend/components/board_list.html"), "UTF-8", "").child(0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public BoardList() {
        super(BASE);
    }

    public @NotNull BoardList consumeEntries(@NotNull List<BoardListEntry> entries) {
        getElement().getElementsByClass("coffeechan#boardEntries").forEach(element ->
                entries.forEach(entry -> element.appendChild(entry.getElement())));

        return this;
    }

    public @NotNull BoardList consumeBoards(@NotNull List<Board> boards) {
        return consumeEntries(boards.stream().map(board -> new BoardListEntry().consumeBoard(board)).toList());
    }
}
