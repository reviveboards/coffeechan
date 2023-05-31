package moe.crx.html.pages;

import moe.crx.core.Configuration;
import moe.crx.html.components.PostComponent;
import org.jetbrains.annotations.NotNull;

public final class BoardPage extends AbstractPage<BoardPage> {

    public BoardPage(@NotNull Configuration config) {
        super("/frontend/pages/board.html", config);

        getElement().getElementsByClass("coffeechan#posts").forEach(element ->
                element.appendChild(new PostComponent().getElement()));
        getElement().getElementsByClass("coffeechan#posts").forEach(element ->
                element.appendChild(new PostComponent().getElement()));
        getElement().getElementsByClass("coffeechan#posts").forEach(element ->
                element.appendChild(new PostComponent().getElement()));
        getElement().getElementsByClass("coffeechan#posts").forEach(element ->
                element.appendChild(new PostComponent().getElement()));
        getElement().getElementsByClass("coffeechan#posts").forEach(element ->
                element.appendChild(new PostComponent().getElement()));
    }
}
