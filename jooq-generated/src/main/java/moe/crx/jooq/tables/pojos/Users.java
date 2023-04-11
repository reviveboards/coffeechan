/*
 * This file is generated by jOOQ.
 */
package moe.crx.jooq.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Long id;
    private final String name;
    private final String country;
    private final String ip;
    private final String passcodehash;
    private final Boolean admin;

    public Users(Users value) {
        this.id = value.id;
        this.name = value.name;
        this.country = value.country;
        this.ip = value.ip;
        this.passcodehash = value.passcodehash;
        this.admin = value.admin;
    }

    public Users(
        Long id,
        String name,
        String country,
        String ip,
        String passcodehash,
        Boolean admin
    ) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.ip = ip;
        this.passcodehash = passcodehash;
        this.admin = admin;
    }

    /**
     * Getter for <code>public.users.id</code>.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Getter for <code>public.users.name</code>.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for <code>public.users.country</code>.
     */
    public String getCountry() {
        return this.country;
    }

    /**
     * Getter for <code>public.users.ip</code>.
     */
    public String getIp() {
        return this.ip;
    }

    /**
     * Getter for <code>public.users.passcodehash</code>.
     */
    public String getPasscodehash() {
        return this.passcodehash;
    }

    /**
     * Getter for <code>public.users.admin</code>.
     */
    public Boolean getAdmin() {
        return this.admin;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Users other = (Users) obj;
        if (this.id == null) {
            if (other.id != null)
                return false;
        }
        else if (!this.id.equals(other.id))
            return false;
        if (this.name == null) {
            if (other.name != null)
                return false;
        }
        else if (!this.name.equals(other.name))
            return false;
        if (this.country == null) {
            if (other.country != null)
                return false;
        }
        else if (!this.country.equals(other.country))
            return false;
        if (this.ip == null) {
            if (other.ip != null)
                return false;
        }
        else if (!this.ip.equals(other.ip))
            return false;
        if (this.passcodehash == null) {
            if (other.passcodehash != null)
                return false;
        }
        else if (!this.passcodehash.equals(other.passcodehash))
            return false;
        if (this.admin == null) {
            if (other.admin != null)
                return false;
        }
        else if (!this.admin.equals(other.admin))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        result = prime * result + ((this.country == null) ? 0 : this.country.hashCode());
        result = prime * result + ((this.ip == null) ? 0 : this.ip.hashCode());
        result = prime * result + ((this.passcodehash == null) ? 0 : this.passcodehash.hashCode());
        result = prime * result + ((this.admin == null) ? 0 : this.admin.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Users (");

        sb.append(id);
        sb.append(", ").append(name);
        sb.append(", ").append(country);
        sb.append(", ").append(ip);
        sb.append(", ").append(passcodehash);
        sb.append(", ").append(admin);

        sb.append(")");
        return sb.toString();
    }
}
