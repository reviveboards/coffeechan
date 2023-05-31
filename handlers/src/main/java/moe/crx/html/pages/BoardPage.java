package moe.crx.html.pages;

import moe.crx.html.components.PostComponent;

public final class BoardPage extends AbstractPage<BoardPage> {

    public BoardPage() {
        super("/frontend/pages/board.html");

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
