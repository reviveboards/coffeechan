package moe.crx.html.components;

import moe.crx.core.util.ReflectionUtil;
import moe.crx.html.pages.AbstractPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.HashMap;

import static moe.crx.core.util.ReflectionUtil.getAllFields;
import static moe.crx.core.util.ReflectionUtil.getClassName;

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

    @SuppressWarnings("unchecked")
    public T cast() {
        return (T) this;
    }

    public @NotNull Element getElement() {
        return element;
    }

    public @NotNull String html() {
        return element.html();
    }

    public @NotNull String toString() {
        return html();
    }

    public @NotNull T consumeField(@NotNull String name, @Nullable Object value) {
        getElement().getElementsByClass("{{" + name + "}}").forEach(element -> {
            if (value == null || value instanceof ReflectionUtil.Null) {
                return;
            }

            element.appendText(value.toString());
        });

        return cast();
    }

    public @NotNull T consumeFields(@NotNull Object object) {
        var prefix = getClassName(object) + ".";

        getAllFields(object).forEach((name, value) ->
                consumeField( prefix + name, value));

        return cast();
    }
}
