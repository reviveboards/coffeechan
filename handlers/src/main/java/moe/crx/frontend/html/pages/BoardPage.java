package moe.crx.frontend.html.pages;

import moe.crx.frontend.html.components.BoardList;
import moe.crx.frontend.html.components.PostComponent;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public final class BoardPage extends AbstractPage<BoardPage> {

    private static final Element BASE;

    static {
        try {
            BASE = Jsoup.parse(BoardList.class.getResourceAsStream("/frontend/pages/board.html"), "UTF-8", "");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public BoardPage() {
        super(BASE);

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
