/*
 * This file is generated by jOOQ.
 */
package moe.crx.jooq.tables.pojos;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Posts implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Long id;
    private final Long poster;
    private final Long board;
    private final Long parent;
    private final LocalDateTime creationtime;
    private final String title;
    private final String message;
    private final Boolean locked;
    private final Boolean visible;
    private final Long[] images;

    public Posts(Posts value) {
        this.id = value.id;
        this.poster = value.poster;
        this.board = value.board;
        this.parent = value.parent;
        this.creationtime = value.creationtime;
        this.title = value.title;
        this.message = value.message;
        this.locked = value.locked;
        this.visible = value.visible;
        this.images = value.images;
    }

    public Posts(
        Long id,
        Long poster,
        Long board,
        Long parent,
        LocalDateTime creationtime,
        String title,
        String message,
        Boolean locked,
        Boolean visible,
        Long[] images
    ) {
        this.id = id;
        this.poster = poster;
        this.board = board;
        this.parent = parent;
        this.creationtime = creationtime;
        this.title = title;
        this.message = message;
        this.locked = locked;
        this.visible = visible;
        this.images = images;
    }

    /**
     * Getter for <code>public.posts.id</code>.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Getter for <code>public.posts.poster</code>.
     */
    public Long getPoster() {
        return this.poster;
    }

    /**
     * Getter for <code>public.posts.board</code>.
     */
    public Long getBoard() {
        return this.board;
    }

    /**
     * Getter for <code>public.posts.parent</code>.
     */
    public Long getParent() {
        return this.parent;
    }

    /**
     * Getter for <code>public.posts.creationtime</code>.
     */
    public LocalDateTime getCreationtime() {
        return this.creationtime;
    }

    /**
     * Getter for <code>public.posts.title</code>.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Getter for <code>public.posts.message</code>.
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * Getter for <code>public.posts.locked</code>.
     */
    public Boolean getLocked() {
        return this.locked;
    }

    /**
     * Getter for <code>public.posts.visible</code>.
     */
    public Boolean getVisible() {
        return this.visible;
    }

    /**
     * Getter for <code>public.posts.images</code>.
     */
    public Long[] getImages() {
        return this.images;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Posts other = (Posts) obj;
        if (this.id == null) {
            if (other.id != null)
                return false;
        }
        else if (!this.id.equals(other.id))
            return false;
        if (this.poster == null) {
            if (other.poster != null)
                return false;
        }
        else if (!this.poster.equals(other.poster))
            return false;
        if (this.board == null) {
            if (other.board != null)
                return false;
        }
        else if (!this.board.equals(other.board))
            return false;
        if (this.parent == null) {
            if (other.parent != null)
                return false;
        }
        else if (!this.parent.equals(other.parent))
            return false;
        if (this.creationtime == null) {
            if (other.creationtime != null)
                return false;
        }
        else if (!this.creationtime.equals(other.creationtime))
            return false;
        if (this.title == null) {
            if (other.title != null)
                return false;
        }
        else if (!this.title.equals(other.title))
            return false;
        if (this.message == null) {
            if (other.message != null)
                return false;
        }
        else if (!this.message.equals(other.message))
            return false;
        if (this.locked == null) {
            if (other.locked != null)
                return false;
        }
        else if (!this.locked.equals(other.locked))
            return false;
        if (this.visible == null) {
            if (other.visible != null)
                return false;
        }
        else if (!this.visible.equals(other.visible))
            return false;
        if (this.images == null) {
            if (other.images != null)
                return false;
        }
        else if (!Arrays.equals(this.images, other.images))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.poster == null) ? 0 : this.poster.hashCode());
        result = prime * result + ((this.board == null) ? 0 : this.board.hashCode());
        result = prime * result + ((this.parent == null) ? 0 : this.parent.hashCode());
        result = prime * result + ((this.creationtime == null) ? 0 : this.creationtime.hashCode());
        result = prime * result + ((this.title == null) ? 0 : this.title.hashCode());
        result = prime * result + ((this.message == null) ? 0 : this.message.hashCode());
        result = prime * result + ((this.locked == null) ? 0 : this.locked.hashCode());
        result = prime * result + ((this.visible == null) ? 0 : this.visible.hashCode());
        result = prime * result + ((this.images == null) ? 0 : Arrays.hashCode(this.images));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Posts (");

        sb.append(id);
        sb.append(", ").append(poster);
        sb.append(", ").append(board);
        sb.append(", ").append(parent);
        sb.append(", ").append(creationtime);
        sb.append(", ").append(title);
        sb.append(", ").append(message);
        sb.append(", ").append(locked);
        sb.append(", ").append(visible);
        sb.append(", ").append(Arrays.toString(images));

        sb.append(")");
        return sb.toString();
    }
}
