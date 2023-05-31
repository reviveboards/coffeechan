package moe.crx.html.components;

import moe.crx.dao.BoardDao;
import moe.crx.dao.CategoryDao;

public final class BoardListCard extends AbstractComponent<BoardListCard> {

    public BoardListCard() {
        super("/frontend/components/board_list_card.html");
    }

    public BoardListCard consumeBoards(CategoryDao categoryDao, BoardDao boardDao) {
        var categories = categoryDao.all().stream().map(category -> new BoardListCategory().consumeCategory(category, boardDao.readAll(category.getBoards())).getElement()).toList();

        getElement().getElementsByClass("coffeechan#boardCategories").forEach(element ->
                element.appendChildren(categories));

        return this;
    }
}
