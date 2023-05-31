package moe.crx.html.components;

import moe.crx.dto.Board;
import moe.crx.dto.Category;

import java.util.List;

public final class BoardListCategory extends AbstractComponent<BoardListCategory> {

    public BoardListCategory() {
        super("/frontend/components/board_list_category.html");
    }

    public BoardListCategory consumeCategory(Category category, List<Board> boards) {
        var boardsElements = boards.stream().filter(Board::isVisible).map(board -> new BoardListBoard().consumeBoard(board).getElement()).toList();

        getElement().getElementsByClass("coffeechan#categoryName").forEach(element ->
                element.append(category.getName()));
        getElement().getElementsByClass("coffeechan#categoryBoards").forEach(element -> {
            if (boardsElements.isEmpty()) {
                element.append("*no boards*");
            } else {
                element.appendChildren(boardsElements);
            }
        });

        return this;
    }
}
