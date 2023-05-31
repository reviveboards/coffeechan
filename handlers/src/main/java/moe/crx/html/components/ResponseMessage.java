package moe.crx.html.components;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ResponseMessage extends AbstractComponent<ResponseMessage> {

    private static final String ERROR_HEADER_STYLE = "background-color: #420D0D;";
    private static final String ERROR_CARD_STYLE = "background-color: #8F2828;";
    private static final String WARNING_HEADER_STYLE = "background-color: #423D0D;";
    private static final String WARNING_CARD_STYLE = "background-color: #8F8528;";

    public enum ResponseType {
        MESSAGE, WARNING, ERROR
    }

    public ResponseMessage(@NotNull ResponseType type) {
        this(type, null);
    }

    public ResponseMessage(@NotNull ResponseType type, @Nullable String message) {
        super("/frontend/components/response_message.html");

        switch (type) {
            case ERROR -> {
                getElement().getElementsByClass("coffeechan#responseCard").forEach(element ->
                        element.attr("style", ERROR_CARD_STYLE));
                getElement().getElementsByClass("coffeechan#responseHeader").forEach(element ->
                        element.attr("style", ERROR_HEADER_STYLE));
                getElement().getElementsByClass("coffeechan#responseType").forEach(element ->
                        element.append("Error"));
                getElement().getElementsByClass("coffeechan#responseMessage").forEach(element ->
                        element.append(message != null ? message : "Unknown error"));
            }
            case WARNING -> {
                getElement().getElementsByClass("coffeechan#responseCard").forEach(element ->
                        element.attr("style", WARNING_CARD_STYLE));
                getElement().getElementsByClass("coffeechan#responseHeader").forEach(element ->
                        element.attr("style", WARNING_HEADER_STYLE));
                getElement().getElementsByClass("coffeechan#responseType").forEach(element ->
                        element.append("Warning"));
                getElement().getElementsByClass("coffeechan#responseMessage").forEach(element ->
                        element.append(message != null ? message : "Unknown warning"));
            }
            case MESSAGE -> {
                getElement().getElementsByClass("coffeechan#responseType").forEach(element ->
                        element.append("Message"));
                getElement().getElementsByClass("coffeechan#responseMessage").forEach(element ->
                        element.append(message != null ? message : "Unknown message"));
            }
        }
    }
}
