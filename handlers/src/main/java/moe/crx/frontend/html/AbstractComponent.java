package moe.crx.frontend.html;

import moe.crx.frontend.html.pages.AbstractPage;
import org.jetbrains.annotations.NotNull;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.HashMap;

public abstract class AbstractComponent<T extends AbstractComponent<T>> {

    private static final HashMap<String, Element> LOADED_ELEMENTS = new HashMap<>();

    private final Element element;

    public AbstractComponent(@NotNull String url) {
        var loaded = LOADED_ELEMENTS.get(url);

        if (loaded == null) {
            try {
                loaded = Jsoup.parse(AbstractComponent.class.getResourceAsStream(url), "UTF-8", "");
                LOADED_ELEMENTS.put(url, loaded);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        if (!(this instanceof AbstractPage))
            element = loaded.child(0).clone();
        else
            element = loaded.clone();
    }

    public T cast() {
        return (T) this;
    }

    public @NotNull Element getElement() {
        return element;
    }

    public @NotNull String html() {
        return element.html();
    }
}
