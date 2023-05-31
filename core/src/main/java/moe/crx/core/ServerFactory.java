package moe.crx.core;

import com.google.inject.Inject;
import org.eclipse.jetty.server.*;
import org.jetbrains.annotations.NotNull;

public final class ServerFactory {

    private int port;

    @Inject
    public ServerFactory(@NotNull ConfigurationFactory configurationFactory) {
        this.port = configurationFactory.getInstance().getWebserverPort();
    }

    public Server getServer() {
        final var server = new Server();
        final var connector = new ServerConnector(server, new HttpConnectionFactory(new HttpConfiguration()));
        connector.setHost("localhost");
        connector.setPort(port);
        server.setConnectors(new Connector[] { connector });
        server.setRequestLog(new CustomRequestLog());
        return server;
    }
}
