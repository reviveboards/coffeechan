package moe.crx.handlers;

import com.google.inject.Inject;
import jakarta.ws.rs.core.Feature;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.jetbrains.annotations.NotNull;

public final class ServletContextHandlerFactory extends ResourceConfig implements IHandlerFactory {

    @Inject
    public ServletContextHandlerFactory(@NotNull Feature... rests) {
        for (Feature rest : rests) {
            register(rest);
        }
    }

    public @NotNull ServletContextHandler getHandler() {
        final var handler = new ServletContextHandler();
        handler.addServlet(new ServletHolder(new ServletContainer(this)), "/*");
        return handler;
    }
}
