package moe.crx.html.pages;

import moe.crx.api.BoardsApi;
import moe.crx.api.CategoriesApi;
import moe.crx.core.Configuration;
import moe.crx.dto.Board;
import moe.crx.dto.Category;
import moe.crx.html.components.BoardManagerCategory;
import moe.crx.html.components.ResponseMessage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AdminPanelPage extends AbstractPage<AdminPanelPage> {

    public AdminPanelPage(@NotNull Configuration config) {
        super("/frontend/pages/admin.html", config);
    }

    public AdminPanelPage consumeCategories(CategoriesApi categoriesApi, BoardsApi boardsApi) {
        var categories = categoriesApi.getAll();

        var categoriesElements = categories.stream().map(category ->
                new BoardManagerCategory().consume(category, boardsApi.getBoards(category.getBoards())));

        var categoriesCombobox = categories.stream().map(category -> "<option value=\"%d\">%s</option>".formatted(category.getId(), category.getName()));

        getElement().getElementsByClass("coffeechan#categoriesCombobox").forEach(element ->
                categoriesCombobox.forEach(element::append));

        getElement().getElementsByClass("coffeechan#categories").forEach(element ->
                categoriesElements.forEach(categoriesElement -> element.append(categoriesElement.html())));

        return this;
    }

    @Override
    public @NotNull AdminPanelPage consumeResponse(@Nullable Object response) {
        if (response instanceof Board) {
            return consumeResponse(new ResponseMessage(ResponseMessage.ResponseType.MESSAGE,
                    "Board has been successfully created."));
        }

        if (response instanceof Category) {
            return consumeResponse(new ResponseMessage(ResponseMessage.ResponseType.MESSAGE,
                    "Category has been successfully created."));
        }

        return super.consumeResponse(response);
    }
}
