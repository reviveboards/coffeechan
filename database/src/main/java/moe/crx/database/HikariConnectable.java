package moe.crx.database;

import com.google.inject.Inject;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import moe.crx.core.Configuration;
import moe.crx.core.ConfigurationFactory;
import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;

public abstract class HikariConnectable {

    @NotNull
    private final HikariDataSource dataSource;
    @NotNull
    private final Configuration configuration;

    public HikariConnectable(@NotNull ConfigurationFactory configurationFactory) {
        this.configuration = configurationFactory.getInstance();
        var hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(String.format("jdbc:%s://%s/%s",
                configuration.getDatabase().getType(),
                configuration.getDatabase().getHostname(),
                configuration.getDatabase().getDatabase()));
        hikariConfig.setUsername(configuration.getDatabase().getUsername());
        hikariConfig.setPassword(configuration.getDatabase().getPassword());
        this.dataSource = new HikariDataSource(hikariConfig);
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
