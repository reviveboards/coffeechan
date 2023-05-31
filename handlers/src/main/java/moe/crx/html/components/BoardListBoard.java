package moe.crx.html.components;

import moe.crx.dto.Board;
import org.jetbrains.annotations.NotNull;

public final class BoardListBoard extends AbstractComponent<BoardListBoard> {

    public BoardListBoard() {
        super("/frontend/components/board_list_board.html");
    }

    public BoardListBoard consumeBoard(@NotNull Board board) {
        getElement().getElementsByClass("coffeechan#boardName").forEach(element ->
                element.append(board.getName()));
        getElement().getElementsByClass("coffeechan#boardTagSlashed").forEach(element ->
                element.append(board.getTagSlashed()));
        getElement().getElementsByClass("coffeechan#boardLink").forEach(element ->
                element.attr("href", board.getLink()));

        return this;
    }
}
