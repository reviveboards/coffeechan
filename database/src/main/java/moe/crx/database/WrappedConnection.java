package moe.crx.database;

import com.google.inject.Inject;
import lombok.Getter;
import lombok.experimental.Accessors;
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

    @Inject
    public WrappedConnection(@NotNull Connection connection) {
        this.connection = connection;
        this.context = DSL.using(connection, SQLDialect.POSTGRES);
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
