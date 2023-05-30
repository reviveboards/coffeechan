package moe.crx.database;

import com.google.inject.Inject;
import moe.crx.core.ConfigurationFactory;
import org.flywaydb.core.Flyway;
import org.jetbrains.annotations.NotNull;

public final class FlywayFactory {

    private final Flyway instance;

    @Inject
    public FlywayFactory(@NotNull ConfigurationFactory configurationFactory) {
        final var config = configurationFactory.getInstance();

        instance = Flyway
                .configure()
                .dataSource(String.format("jdbc:%s://%s/%s",
                                config.getDatabase().getType(),
                                config.getDatabase().getHostname(),
                                config.getDatabase().getDatabase()),
                        config.getDatabase().getUsername(),
                        config.getDatabase().getPassword())
                .locations("sql")
                .load();
    }

    @NotNull
    public Flyway getInstance() {
        return instance;
    }
}
