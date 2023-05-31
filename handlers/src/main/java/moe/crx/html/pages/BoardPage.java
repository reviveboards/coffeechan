package moe.crx.html.pages;

import moe.crx.api.PostsApi;
import moe.crx.core.Configuration;
import moe.crx.dto.Board;
import moe.crx.html.components.PostComponent;
import org.jetbrains.annotations.NotNull;

public final class BoardPage extends AbstractPage<BoardPage> {

    public BoardPage(@NotNull Configuration config) {
        super("/frontend/pages/board.html", config);
    }

    public BoardPage consumeBoard(Board board, PostsApi postsApi) {
        getElement().getElementsByClass("coffeechan#boardName").forEach(element ->
                element.append(board.getName()));
        getElement().getElementsByClass("coffeechan#boardTagSlashed").forEach(element ->
                element.append(board.getTagSlashed()));

        var posts = postsApi.getThreads(board.getId()).stream().map(post -> new PostComponent().consumePost(post).getElement()).toList();

        getElement().getElementsByClass("coffeechan#posts").forEach(element ->
                element.appendChildren(posts));

        return this;
    }
}
