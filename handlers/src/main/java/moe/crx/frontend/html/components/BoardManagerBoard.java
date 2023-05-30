package moe.crx.frontend.html.components;

import moe.crx.dto.Board;
import moe.crx.frontend.html.AbstractComponent;
import org.jetbrains.annotations.NotNull;

public final class BoardManagerBoard extends AbstractComponent<BoardManagerBoard> {

    public BoardManagerBoard() {
        super("/frontend/components/board_manager_board.html");
    }

    public BoardManagerBoard consumeBoard(@NotNull Board board) {
        getElement().getElementsByClass("coffeechan#boardTagSlashed").forEach(element ->
                element.append(board.getTagSlashed()));
        getElement().getElementsByClass("coffeechan#boardName").forEach(element ->
                element.append(board.getName()));

        return this;
    }
}
