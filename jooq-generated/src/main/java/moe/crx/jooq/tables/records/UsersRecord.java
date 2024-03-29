/*
 * This file is generated by jOOQ.
 */
package moe.crx.jooq.tables.records;


import moe.crx.jooq.tables.Users;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UsersRecord extends UpdatableRecordImpl<UsersRecord> implements Record6<Long, String, String, String, String, Boolean> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.users.id</code>.
     */
    public UsersRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.users.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.users.name</code>.
     */
    public UsersRecord setName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.users.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.users.country</code>.
     */
    public UsersRecord setCountry(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.users.country</code>.
     */
    public String getCountry() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.users.ip</code>.
     */
    public UsersRecord setIp(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.users.ip</code>.
     */
    public String getIp() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.users.hash</code>.
     */
    public UsersRecord setHash(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.users.hash</code>.
     */
    public String getHash() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.users.admin</code>.
     */
    public UsersRecord setAdmin(Boolean value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>public.users.admin</code>.
     */
    public Boolean getAdmin() {
        return (Boolean) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row6<Long, String, String, String, String, Boolean> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    @Override
    public Row6<Long, String, String, String, String, Boolean> valuesRow() {
        return (Row6) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Users.USERS.ID;
    }

    @Override
    public Field<String> field2() {
        return Users.USERS.NAME;
    }

    @Override
    public Field<String> field3() {
        return Users.USERS.COUNTRY;
    }

    @Override
    public Field<String> field4() {
        return Users.USERS.IP;
    }

    @Override
    public Field<String> field5() {
        return Users.USERS.HASH;
    }

    @Override
    public Field<Boolean> field6() {
        return Users.USERS.ADMIN;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public String component3() {
        return getCountry();
    }

    @Override
    public String component4() {
        return getIp();
    }

    @Override
    public String component5() {
        return getHash();
    }

    @Override
    public Boolean component6() {
        return getAdmin();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public String value3() {
        return getCountry();
    }

    @Override
    public String value4() {
        return getIp();
    }

    @Override
    public String value5() {
        return getHash();
    }

    @Override
    public Boolean value6() {
        return getAdmin();
    }

    @Override
    public UsersRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public UsersRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public UsersRecord value3(String value) {
        setCountry(value);
        return this;
    }

    @Override
    public UsersRecord value4(String value) {
        setIp(value);
        return this;
    }

    @Override
    public UsersRecord value5(String value) {
        setHash(value);
        return this;
    }

    @Override
    public UsersRecord value6(Boolean value) {
        setAdmin(value);
        return this;
    }

    @Override
    public UsersRecord values(Long value1, String value2, String value3, String value4, String value5, Boolean value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UsersRecord
     */
    public UsersRecord() {
        super(Users.USERS);
    }

    /**
     * Create a detached, initialised UsersRecord
     */
    public UsersRecord(Long id, String name, String country, String ip, String hash, Boolean admin) {
        super(Users.USERS);

        setId(id);
        setName(name);
        setCountry(country);
        setIp(ip);
        setHash(hash);
        setAdmin(admin);
    }

    /**
     * Create a detached, initialised UsersRecord
     */
    public UsersRecord(moe.crx.jooq.tables.pojos.Users value) {
        super(Users.USERS);

        if (value != null) {
            setId(value.getId());
            setName(value.getName());
            setCountry(value.getCountry());
            setIp(value.getIp());
            setHash(value.getHash());
            setAdmin(value.getAdmin());
        }
    }
}
