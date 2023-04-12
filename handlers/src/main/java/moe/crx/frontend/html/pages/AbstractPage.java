package moe.crx.frontend.html.pages;

import moe.crx.core.Configuration;
import moe.crx.frontend.html.AbstractComponent;
import org.jetbrains.annotations.NotNull;
import org.jsoup.nodes.Element;

public abstract class AbstractPage<T extends AbstractPage<T>> extends AbstractComponent<T> {

    public AbstractPage(@NotNull Element base) {
        super(base);
    }

    public @NotNull AbstractPage<T> consumeMotd(@NotNull String motd) {
        getElement().getElementsByClass("coffeechan#motd").forEach(element ->
                element.append(motd));
        return this;
    }

    public @NotNull AbstractPage<T> consumeTitle(@NotNull String title) {
        getElement().getElementsByClass("coffeechan#title").forEach(element ->
                element.append(title));
        return this;
    }

    public @NotNull AbstractPage<T> consumeConfig(@NotNull Configuration config) {
        consumeMotd(config.getRandomMotd());
        consumeTitle(config.getTitle());
        return this;
    }
}
