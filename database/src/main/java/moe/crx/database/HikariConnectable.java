package moe.crx.database;

import com.google.inject.Inject;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import moe.crx.core.Configuration;
import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;

public abstract class HikariConnectable {

    @NotNull
    private final HikariDataSource dataSource;
    @NotNull
    private final Configuration configuration;

    @Inject
    public HikariConnectable(@NotNull Configuration config) {
        var hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(String.format("jdbc:%s://%s/%s",
                config.getDatabase().getType(),
                config.getDatabase().getHostname(),
                config.getDatabase().getDatabase()));
        hikariConfig.setUsername(config.getDatabase().getUsername());
        hikariConfig.setPassword(config.getDatabase().getPassword());
        this.dataSource = new HikariDataSource(hikariConfig);
        this.configuration = config;
    }

    @NotNull
    protected WrappedConnection getConnection() {
        try {
            return new WrappedConnection(configuration, dataSource.getConnection());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
