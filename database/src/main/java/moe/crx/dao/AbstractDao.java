package moe.crx.dao;

import com.google.inject.Inject;
import com.zaxxer.hikari.HikariDataSource;
import moe.crx.database.HikariConnectable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jooq.*;

import java.util.List;

public abstract class AbstractDao<Type, RecordType extends UpdatableRecord<?>, KeyType> extends HikariConnectable {

    private final Table<RecordType> table;
    private final TableField<RecordType, KeyType> keyField;
    private final boolean isKeySerial;
    private final TableField<RecordType, ?>[] exclusiveFields;
    private final Class<Type> clazz;

    @SafeVarargs
    @Inject
    public AbstractDao(@NotNull Class<Type> pojoClazz,
                       @NotNull HikariDataSource dataSource,
                       @NotNull Table<RecordType> table,
                       @NotNull TableField<RecordType, KeyType> keyField,
                       boolean isKeySerial,
                       @NotNull TableField<RecordType, ?>... exclusiveFields) {
        super(dataSource);
        this.clazz = pojoClazz;
        this.table = table;
        this.keyField = keyField;
        this.isKeySerial = isKeySerial;
        this.exclusiveFields = exclusiveFields;
    }

    public @Nullable Type read(KeyType id) {
        try (var c = getConnection()) {
            return c.context()
                    .fetchOptional(table, keyField.eq(id))
                    .map(r -> r.into(clazz))
                    .orElse(null);
        }
    }

    public @NotNull List<@NotNull Type> all() {
        try (var c = getConnection()) {
            return c.context()
                    .fetch(table)
                    .into(clazz);
        }
    }

    public @Nullable Type create(@NotNull Type item) {
        try (var c = getConnection()) {
            var record = c.context().newRecord(table, item);
            if (isKeySerial)
                record.reset(keyField);
            return c.context()
                    .insertInto(table)
                    .set(record)
                    .onConflict(exclusiveFields)
                    .doUpdate()
                    .set(record)
                    .returning()
                    .fetchOptional()
                    .map(r -> r.into(clazz))
                    .orElse(null);
        }
    }

    public boolean update(@NotNull Type item) {
        try (var c = getConnection()) {
            var record = c.context().newRecord(table, item);
            return c.context().executeUpdate(record) != 0;
        }
    }

    public boolean delete(@NotNull Type item) {
        try (var c = getConnection()) {
            var record = c.context().newRecord(table, item);
            return c.context().executeDelete(record) != 0;
        }
    }
}
