package moe.crx.html.components;

import moe.crx.dto.Board;
import moe.crx.dto.Category;

import java.util.List;

public final class BoardManagerCategory extends AbstractComponent<BoardManagerCategory> {

    public BoardManagerCategory() {
        super("/frontend/components/board_manager_category.html");
    }

    public BoardManagerCategory consume(Category category, List<Board> boards) {
        var boardsElements = boards.stream().map(board -> new BoardManagerBoard().consumeBoard(board));

        getElement().getElementsByClass("coffeechan#name").forEach(element ->
                element.append(category.getName()));
        getElement().getElementsByClass("coffeechan#boards").forEach(element ->
                boardsElements.forEach(boardsElement -> element.append(boardsElement.html())));

        return this;
    }
}
