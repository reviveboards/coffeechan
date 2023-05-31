package moe.crx.html.components;

import moe.crx.api.BoardsApi;
import moe.crx.api.CategoriesApi;
import moe.crx.dto.Category;

public final class BoardListCard extends AbstractComponent<BoardListCard> {

    public BoardListCard() {
        super("/frontend/components/board_list_card.html");
    }

    public BoardListCard consumeBoards(CategoriesApi categoriesApi, BoardsApi boardsApi) {
        var categories = categoriesApi.getAll().stream().filter(Category::isVisible).map(category -> new BoardListCategory().consumeCategory(category, boardsApi.getBoards(category.getBoards())).getElement()).toList();

        getElement().getElementsByClass("coffeechan#boardCategories").forEach(element -> {
            if (categories.isEmpty()) {
                element.append("There are no boards.");
            } else {
                element.appendChildren(categories);
            }
        });

        return this;
    }
}
