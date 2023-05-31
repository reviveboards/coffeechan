package moe.crx.html.pages;

import moe.crx.core.Configuration;
import org.jetbrains.annotations.NotNull;

public final class MessagePage extends AbstractPage<MessagePage> {

    public MessagePage(@NotNull Configuration config) {
        super("/frontend/pages/message_page.html", config);
    }
}
