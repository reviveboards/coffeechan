package moe.crx.core;

import org.eclipse.jetty.server.*;

public final class ServerFactory {

    public Server getServer(int port) {
        final var server = new Server();
        final var connector = new ServerConnector(server, new HttpConnectionFactory(new HttpConfiguration()));
        connector.setHost("localhost");
        connector.setPort(port);
        server.setConnectors(new Connector[] { connector });
        return server;
    }
}
