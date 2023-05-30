package moe.crx;

import com.google.inject.Guice;
import moe.crx.core.ConfigurationFactory;
import moe.crx.core.CoreModule;
import moe.crx.core.ServerFactory;
import moe.crx.database.DatabaseModule;
import moe.crx.database.FlywayFactory;
import moe.crx.handlers.HandlersFactory;
import moe.crx.handlers.HandlersModule;
import org.jetbrains.annotations.NotNull;

public final class Starter {

    public static void main(@NotNull String[] args) throws Exception {
        final var injector = Guice.createInjector(
                new CoreModule(),
                new DatabaseModule(),
                new HandlersModule()
        );

        injector.getInstance(ConfigurationFactory.class).getInstance(args);
        injector.getInstance(FlywayFactory.class).getInstance().migrate();

        final var server = injector.getInstance(ServerFactory.class).getServer();
        final var factory = injector.getInstance(HandlersFactory.class);

        server.setHandler(factory.getHandlers());
        server.start();
    }
}