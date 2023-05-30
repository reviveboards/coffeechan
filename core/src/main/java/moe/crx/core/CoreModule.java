package moe.crx.core;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import org.jetbrains.annotations.NotNull;

public final class CoreModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ServerFactory.class);
        bind(ConfigurationFactory.class);
    }
}
