package moe.crx.database;

import lombok.Getter;
import lombok.experimental.Accessors;
import moe.crx.core.Configuration;
import org.jetbrains.annotations.NotNull;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.SQLException;

public final class WrappedConnection implements Closeable {

    private final Connection connection;
    @Accessors(fluent = true)
    @Getter
    private final DSLContext context;

    public WrappedConnection(@NotNull Configuration config,
                             @NotNull Connection connection) {
        this.connection = connection;

        var databaseType = config.getDatabase().getType();
        if (databaseType == null || "postgresql".equalsIgnoreCase(databaseType)) {
            databaseType = "postgres";
        }

        this.context = DSL.using(connection, SQLDialect.valueOf(databaseType.toUpperCase()));
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
