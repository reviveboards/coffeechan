package moe.crx;

import com.google.inject.Guice;
import moe.crx.core.ConfigurationFactory;
import moe.crx.core.CoreModule;
import moe.crx.core.InputArgs;
import moe.crx.core.ServerFactory;
import moe.crx.database.DatabaseModule;
import moe.crx.handlers.HandlersFactory;
import moe.crx.handlers.HandlersModule;
import org.flywaydb.core.Flyway;
import org.jetbrains.annotations.NotNull;

public final class Starter {

    public static void main(@NotNull String[] rawArgs) throws Exception {
        var injector = Guice.createInjector(new CoreModule(rawArgs));
        final var args = injector.getInstance(InputArgs.class);
        injector = injector.createChildInjector(
                new DatabaseModule(args),
                new HandlersModule()
        );

        injector.getInstance(ConfigurationFactory.class).getInstance(args.getConfigPath());
        injector.getInstance(Flyway.class).migrate();

        final var server = injector.getInstance(ServerFactory.class).getServer(80);
        final var factory = injector.getInstance(HandlersFactory.class);
        server.setHandler(factory.getHandlers());
        server.start();
    }
}