/*
 * This file is generated by jOOQ.
 */
package moe.crx.jooq.tables;


import java.util.function.Function;

import moe.crx.jooq.Keys;
import moe.crx.jooq.Public;
import moe.crx.jooq.tables.records.ImagesRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function6;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row6;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Images extends TableImpl<ImagesRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.images</code>
     */
    public static final Images IMAGES = new Images();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ImagesRecord> getRecordType() {
        return ImagesRecord.class;
    }

    /**
     * The column <code>public.images.id</code>.
     */
    public final TableField<ImagesRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.images.url</code>.
     */
    public final TableField<ImagesRecord, String> URL = createField(DSL.name("url"), SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.images.filename</code>.
     */
    public final TableField<ImagesRecord, String> FILENAME = createField(DSL.name("filename"), SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.images.width</code>.
     */
    public final TableField<ImagesRecord, Integer> WIDTH = createField(DSL.name("width"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.images.height</code>.
     */
    public final TableField<ImagesRecord, Integer> HEIGHT = createField(DSL.name("height"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.images.filesize</code>.
     */
    public final TableField<ImagesRecord, Long> FILESIZE = createField(DSL.name("filesize"), SQLDataType.BIGINT.nullable(false), this, "");

    private Images(Name alias, Table<ImagesRecord> aliased) {
        this(alias, aliased, null);
    }

    private Images(Name alias, Table<ImagesRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.images</code> table reference
     */
    public Images(String alias) {
        this(DSL.name(alias), IMAGES);
    }

    /**
     * Create an aliased <code>public.images</code> table reference
     */
    public Images(Name alias) {
        this(alias, IMAGES);
    }

    /**
     * Create a <code>public.images</code> table reference
     */
    public Images() {
        this(DSL.name("images"), null);
    }

    public <O extends Record> Images(Table<O> child, ForeignKey<O, ImagesRecord> key) {
        super(child, key, IMAGES);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public Identity<ImagesRecord, Long> getIdentity() {
        return (Identity<ImagesRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<ImagesRecord> getPrimaryKey() {
        return Keys.IMAGES_PK;
    }

    @Override
    public Images as(String alias) {
        return new Images(DSL.name(alias), this);
    }

    @Override
    public Images as(Name alias) {
        return new Images(alias, this);
    }

    @Override
    public Images as(Table<?> alias) {
        return new Images(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Images rename(String name) {
        return new Images(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Images rename(Name name) {
        return new Images(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Images rename(Table<?> name) {
        return new Images(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<Long, String, String, Integer, Integer, Long> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function6<? super Long, ? super String, ? super String, ? super Integer, ? super Integer, ? super Long, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function6<? super Long, ? super String, ? super String, ? super Integer, ? super Integer, ? super Long, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
