package moe.crx.handlers;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.util.resource.Resource;
import org.jetbrains.annotations.NotNull;

public final class ResourceHandlerFactory implements IHandlerFactory {

    public @NotNull Handler getHandler() {
        var contextHandler = new ContextHandler("/static");
        var resourceHandler = new ResourceHandler();
        resourceHandler.setDirectoriesListed(false);
        resourceHandler.setBaseResource(Resource.newResource(getClass().getResource("/static")));
        resourceHandler.setWelcomeFiles(new String[] { "index.html" });
        contextHandler.setHandler(resourceHandler);
        return contextHandler;
    }
}
