package moe.crx.handlers;

import org.eclipse.jetty.server.Handler;

public interface IHandlerFactory {
    Handler getHandler();
}
