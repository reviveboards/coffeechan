/*
 * This file is generated by jOOQ.
 */
package moe.crx.jooq.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Images implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Long id;
    private final String url;
    private final String squared;
    private final String filename;
    private final Integer width;
    private final Integer height;
    private final Long filesize;
    private final String alt;

    public Images(Images value) {
        this.id = value.id;
        this.url = value.url;
        this.squared = value.squared;
        this.filename = value.filename;
        this.width = value.width;
        this.height = value.height;
        this.filesize = value.filesize;
        this.alt = value.alt;
    }

    public Images(
        Long id,
        String url,
        String squared,
        String filename,
        Integer width,
        Integer height,
        Long filesize,
        String alt
    ) {
        this.id = id;
        this.url = url;
        this.squared = squared;
        this.filename = filename;
        this.width = width;
        this.height = height;
        this.filesize = filesize;
        this.alt = alt;
    }

    /**
     * Getter for <code>public.images.id</code>.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Getter for <code>public.images.url</code>.
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * Getter for <code>public.images.squared</code>.
     */
    public String getSquared() {
        return this.squared;
    }

    /**
     * Getter for <code>public.images.filename</code>.
     */
    public String getFilename() {
        return this.filename;
    }

    /**
     * Getter for <code>public.images.width</code>.
     */
    public Integer getWidth() {
        return this.width;
    }

    /**
     * Getter for <code>public.images.height</code>.
     */
    public Integer getHeight() {
        return this.height;
    }

    /**
     * Getter for <code>public.images.filesize</code>.
     */
    public Long getFilesize() {
        return this.filesize;
    }

    /**
     * Getter for <code>public.images.alt</code>.
     */
    public String getAlt() {
        return this.alt;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Images other = (Images) obj;
        if (this.id == null) {
            if (other.id != null)
                return false;
        }
        else if (!this.id.equals(other.id))
            return false;
        if (this.url == null) {
            if (other.url != null)
                return false;
        }
        else if (!this.url.equals(other.url))
            return false;
        if (this.squared == null) {
            if (other.squared != null)
                return false;
        }
        else if (!this.squared.equals(other.squared))
            return false;
        if (this.filename == null) {
            if (other.filename != null)
                return false;
        }
        else if (!this.filename.equals(other.filename))
            return false;
        if (this.width == null) {
            if (other.width != null)
                return false;
        }
        else if (!this.width.equals(other.width))
            return false;
        if (this.height == null) {
            if (other.height != null)
                return false;
        }
        else if (!this.height.equals(other.height))
            return false;
        if (this.filesize == null) {
            if (other.filesize != null)
                return false;
        }
        else if (!this.filesize.equals(other.filesize))
            return false;
        if (this.alt == null) {
            if (other.alt != null)
                return false;
        }
        else if (!this.alt.equals(other.alt))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.url == null) ? 0 : this.url.hashCode());
        result = prime * result + ((this.squared == null) ? 0 : this.squared.hashCode());
        result = prime * result + ((this.filename == null) ? 0 : this.filename.hashCode());
        result = prime * result + ((this.width == null) ? 0 : this.width.hashCode());
        result = prime * result + ((this.height == null) ? 0 : this.height.hashCode());
        result = prime * result + ((this.filesize == null) ? 0 : this.filesize.hashCode());
        result = prime * result + ((this.alt == null) ? 0 : this.alt.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Images (");

        sb.append(id);
        sb.append(", ").append(url);
        sb.append(", ").append(squared);
        sb.append(", ").append(filename);
        sb.append(", ").append(width);
        sb.append(", ").append(height);
        sb.append(", ").append(filesize);
        sb.append(", ").append(alt);

        sb.append(")");
        return sb.toString();
    }
}
