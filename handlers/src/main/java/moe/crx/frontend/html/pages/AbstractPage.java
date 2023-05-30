package moe.crx.frontend.html.pages;

import moe.crx.core.Configuration;
import moe.crx.frontend.html.AbstractComponent;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractPage<T extends AbstractPage<T>> extends AbstractComponent<T> {

    public AbstractPage(@NotNull String url) {
        super(url);
    }

    public @NotNull T consumeMotd(@NotNull String motd) {
        getElement().getElementsByClass("coffeechan#motd").forEach(element ->
                element.append(motd));
        return cast();
    }

    public @NotNull T consumeTitle(@NotNull String title) {
        getElement().getElementsByClass("coffeechan#title").forEach(element ->
                element.append(title));
        return cast();
    }

    public @NotNull T consumeConfig(@NotNull Configuration config) {
        consumeMotd(config.getRandomMotd());
        consumeTitle(config.getTitle());
        return cast();
    }
}
