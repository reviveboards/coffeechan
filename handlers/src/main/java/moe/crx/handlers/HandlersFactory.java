package moe.crx.handlers;

import com.google.inject.Inject;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

public final class HandlersFactory {

    private final IHandlerFactory[] factories;

    @Inject
    public HandlersFactory(@NotNull IHandlerFactory... factories) {
        this.factories = factories;
    }

    public @NotNull Handler getHandlers() {
        final var list = new HandlerList();
        list.setHandlers(Stream.of(factories).map(IHandlerFactory::getHandler).toArray(Handler[]::new));
        return list;
    }
}
