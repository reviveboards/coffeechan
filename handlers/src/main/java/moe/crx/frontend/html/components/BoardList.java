package moe.crx.frontend.html.components;

import moe.crx.dto.Board;
import moe.crx.frontend.html.AbstractComponent;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public final class BoardList extends AbstractComponent<BoardList> {

    public BoardList() {
        super("/frontend/components/board_list.html");
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
