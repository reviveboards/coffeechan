package moe.crx.frontend.html.components;

import moe.crx.frontend.html.AbstractComponent;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public final class PostComponent extends AbstractComponent<PostComponent> {

    private static final Element BASE;

    static {
        try {
            BASE = Jsoup.parse(BoardList.class.getResourceAsStream("/frontend/components/post.html"), "UTF-8", "").child(0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public PostComponent() {
        super(BASE);
    }
}
