package moe.crx.frontend.html.components;

import moe.crx.dto.Board;
import moe.crx.frontend.html.AbstractComponent;
import org.jetbrains.annotations.NotNull;

public final class BoardListEntry extends AbstractComponent<BoardListEntry> {

    public BoardListEntry() {
        super("/frontend/components/board_list_entry.html");
    }

    public @NotNull BoardListEntry consumeBoard(@NotNull Board board) {
        getElement().getElementsByClass("coffeechan#boardLink").forEach(element ->
                element.attr("href", "/" + board.getTag()));
        getElement().getElementsByClass("coffeechan#boardTagSlashed").forEach(element ->
                element.append("/" + board.getTag() + "/"));
        getElement().getElementsByClass("coffeechan#boardTag").forEach(element ->
                element.append(board.getTag()));
        getElement().getElementsByClass("coffeechan#boardName").forEach(element ->
                element.append(board.getName()));

        return this;
    }
}
