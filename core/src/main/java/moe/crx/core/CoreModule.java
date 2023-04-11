package moe.crx.core;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import org.jetbrains.annotations.NotNull;

public final class CoreModule extends AbstractModule {

    private final String[] args;

    public CoreModule(@NotNull String[] args) {
        this.args = args;
    }

    @Override
    protected void configure() {
        bind(String[].class).annotatedWith(Names.named("consoleArgs")).toInstance(args);
        bind(ServerFactory.class);
        bind(InputArgs.class);
    }
}
