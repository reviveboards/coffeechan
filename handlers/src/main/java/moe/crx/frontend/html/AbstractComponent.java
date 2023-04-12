package moe.crx.frontend.html;

import org.jetbrains.annotations.NotNull;
import org.jsoup.nodes.Element;

public abstract class AbstractComponent<T extends AbstractComponent<T>> {

    private final Element element;

    public AbstractComponent(@NotNull Element base) {
        element = base.clone();
    }

    public @NotNull Element getElement() {
        return element;
    }

    public @NotNull String html() {
        return element.html();
    }
}
