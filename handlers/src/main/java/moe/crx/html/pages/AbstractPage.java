package moe.crx.html.pages;

import moe.crx.core.Configuration;
import moe.crx.dto.APIError;
import moe.crx.html.components.AbstractComponent;
import moe.crx.html.components.ResponseMessage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Calendar;

public abstract class AbstractPage<T extends AbstractPage<T>> extends AbstractComponent<T> {

    private final long creationTimestamp = System.currentTimeMillis();

    public AbstractPage(@NotNull String url, @NotNull Configuration config) {
        super("/frontend/base_page.html");

        final var pageContent = new AbstractComponent<T>(url) {};

        getElement().getElementsByClass("coffeechan#pageContent").forEach(element ->
                element.appendChild(pageContent.getElement()));

        consumeConfig(config);

        consumeYear(Calendar.getInstance().get(Calendar.YEAR));
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

    public @NotNull T consumeResponse(@Nullable Object response) {
        if (response == null || response instanceof APIError) {
            return consumeError(response);
        }

        return consumeResponse(new ResponseMessage(ResponseMessage.ResponseType.MESSAGE));
    }

    public @NotNull T consumeError(@Nullable Object response) {
        if (response == null) {
            return consumeResponse(new ResponseMessage(ResponseMessage.ResponseType.ERROR));
        }

        if (response instanceof APIError error) {
            return consumeResponse(new ResponseMessage(ResponseMessage.ResponseType.ERROR,
                    error.getErrorCode() + ": " + error.getErrorMessage()));
        }

        return cast();
    }

    public @NotNull T consumeResponse(@NotNull ResponseMessage message) {
        getElement().getElementsByClass("coffeechan#responseMessage").forEach(element ->
                element.append(message.html()));

        return cast();
    }

    private @NotNull T consumeConfig(@NotNull Configuration config) {
        consumeMotd(config.getRandomMotd());
        consumeTitle(config.getTitle());

        return cast();
    }

    private @NotNull T consumeYear(int currentYear) {
        getElement().getElementsByClass("coffeechan#currentYear").forEach(element ->
                element.append(String.valueOf(currentYear)));

        return cast();
    }

    public @NotNull String html() {
        getElement().getElementsByClass("coffeechan#generationTime").forEach(element ->
                element.append(" | generated in %d ms".formatted(System.currentTimeMillis() - creationTimestamp)));

        return super.html();
    }
}
