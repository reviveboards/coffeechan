package moe.crx.html.pages;

import moe.crx.core.Configuration;
import moe.crx.dto.APIError;
import moe.crx.html.components.AbstractComponent;
import moe.crx.html.components.ResponseMessage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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

    public @NotNull T consumeResponse(@Nullable Object response) {
        if (response == null) {
            return consumeResponse(new ResponseMessage(ResponseMessage.ResponseType.ERROR));
        }

        if (response instanceof APIError error) {
            return consumeResponse(new ResponseMessage(ResponseMessage.ResponseType.ERROR,
                    error.getErrorCode() + ": " + error.getErrorMessage()));
        }

        return consumeResponse(new ResponseMessage(ResponseMessage.ResponseType.MESSAGE));
    }

    public @NotNull T consumeResponse(@NotNull ResponseMessage message) {
        getElement().getElementsByClass("coffeechan#responseMessage").forEach(element ->
                element.append(message.html()));

        return cast();
    }

    public @NotNull T consumeConfig(@NotNull Configuration config) {
        consumeMotd(config.getRandomMotd());
        consumeTitle(config.getTitle());
        return cast();
    }
}
