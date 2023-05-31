package moe.crx.api;

import moe.crx.core.ConfigurationFactory;
import moe.crx.database.HikariConnectable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jooq.*;

import java.util.List;

abstract class AbstractDao<Type, RecordType extends UpdatableRecord<?>, KeyType> extends HikariConnectable {

    private final Table<RecordType> table;
    private final TableField<RecordType, KeyType> keyField;
    private final boolean isKeySerial;
    private final TableField<RecordType, ?>[] exclusiveFields;
    private final Class<Type> clazz;

    @SafeVarargs
    public AbstractDao(@NotNull ConfigurationFactory configurationFactory,
                       @NotNull Class<Type> pojoClazz,
                       @NotNull Table<RecordType> table,
                       @NotNull TableField<RecordType, KeyType> keyField,
                       boolean isKeySerial,
                       @NotNull TableField<RecordType, ?>... exclusiveFields) {
        super(configurationFactory);
        this.clazz = pojoClazz;
        this.table = table;
        this.keyField = keyField;
        this.isKeySerial = isKeySerial;
        this.exclusiveFields = exclusiveFields;
    }

    public @Nullable Type read(@NotNull KeyType id) {
        return readBy(keyField, id);
    }

    public @Nullable <FieldType> Type readBy(@NotNull TableField<RecordType, FieldType> field, @NotNull FieldType value) {
        try (var c = getConnection()) {
            return c.context()
                    .fetchOptional(table, field.eq(value))
                    .map(r -> r.into(clazz))
                    .orElse(null);
        }
    }

    public @NotNull List<@NotNull Type> readAll(@NotNull List<@NotNull KeyType> ids) {
        try (var c = getConnection()) {
            return c.context()
                    .fetch(table, keyField.in(ids))
                    .map(r -> r.into(clazz));
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
