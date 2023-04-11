package moe.crx.database;

import com.google.inject.AbstractModule;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import moe.crx.core.InputArgs;
import moe.crx.dao.BoardDao;
import org.flywaydb.core.Flyway;
import org.jetbrains.annotations.NotNull;

public final class DatabaseModule extends AbstractModule {

    @NotNull private final InputArgs args;

    public DatabaseModule(@NotNull InputArgs args) {
        this.args = args;
    }

    @Override
    protected void configure() {
        bind(BoardDao.class);
        bind(Flyway.class).toInstance(Flyway
                .configure()
                .dataSource(String.format("jdbc:postgresql://%s/%s", args.getHostname(), args.getDatabase()),
                        args.getUsername(), args.getPassword())
                .locations("sql")
                .load());

        var hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(String.format("jdbc:postgresql://%s/%s", args.getHostname(), args.getDatabase()));
        hikariConfig.setUsername(args.getUsername());
        hikariConfig.setPassword(args.getPassword());
        bind(HikariDataSource.class).toInstance(new HikariDataSource(hikariConfig));
    }
}
