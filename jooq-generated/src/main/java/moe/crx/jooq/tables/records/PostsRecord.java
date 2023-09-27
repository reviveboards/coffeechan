/*
 * This file is generated by jOOQ.
 */
package moe.crx.jooq.tables.records;


import java.time.LocalDateTime;

import moe.crx.jooq.tables.Posts;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record10;
import org.jooq.Row10;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PostsRecord extends UpdatableRecordImpl<PostsRecord> implements Record10<Long, Long, Long, Long, LocalDateTime, String, String, Boolean, Boolean, Long[]> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.posts.id</code>.
     */
    public PostsRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.posts.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.posts.poster</code>.
     */
    public PostsRecord setPoster(Long value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.posts.poster</code>.
     */
    public Long getPoster() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.posts.board</code>.
     */
    public PostsRecord setBoard(Long value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.posts.board</code>.
     */
    public Long getBoard() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>public.posts.parent</code>.
     */
    public PostsRecord setParent(Long value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.posts.parent</code>.
     */
    public Long getParent() {
        return (Long) get(3);
    }

    /**
     * Setter for <code>public.posts.creationtime</code>.
     */
    public PostsRecord setCreationtime(LocalDateTime value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.posts.creationtime</code>.
     */
    public LocalDateTime getCreationtime() {
        return (LocalDateTime) get(4);
    }

    /**
     * Setter for <code>public.posts.title</code>.
     */
    public PostsRecord setTitle(String value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>public.posts.title</code>.
     */
    public String getTitle() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.posts.message</code>.
     */
    public PostsRecord setMessage(String value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>public.posts.message</code>.
     */
    public String getMessage() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.posts.locked</code>.
     */
    public PostsRecord setLocked(Boolean value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>public.posts.locked</code>.
     */
    public Boolean getLocked() {
        return (Boolean) get(7);
    }

    /**
     * Setter for <code>public.posts.visible</code>.
     */
    public PostsRecord setVisible(Boolean value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>public.posts.visible</code>.
     */
    public Boolean getVisible() {
        return (Boolean) get(8);
    }

    /**
     * Setter for <code>public.posts.images</code>.
     */
    public PostsRecord setImages(Long[] value) {
        set(9, value);
        return this;
    }

    /**
     * Getter for <code>public.posts.images</code>.
     */
    public Long[] getImages() {
        return (Long[]) get(9);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record10 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row10<Long, Long, Long, Long, LocalDateTime, String, String, Boolean, Boolean, Long[]> fieldsRow() {
        return (Row10) super.fieldsRow();
    }

    @Override
    public Row10<Long, Long, Long, Long, LocalDateTime, String, String, Boolean, Boolean, Long[]> valuesRow() {
        return (Row10) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Posts.POSTS.ID;
    }

    @Override
    public Field<Long> field2() {
        return Posts.POSTS.POSTER;
    }

    @Override
    public Field<Long> field3() {
        return Posts.POSTS.BOARD;
    }

    @Override
    public Field<Long> field4() {
        return Posts.POSTS.PARENT;
    }

    @Override
    public Field<LocalDateTime> field5() {
        return Posts.POSTS.CREATIONTIME;
    }

    @Override
    public Field<String> field6() {
        return Posts.POSTS.TITLE;
    }

    @Override
    public Field<String> field7() {
        return Posts.POSTS.MESSAGE;
    }

    @Override
    public Field<Boolean> field8() {
        return Posts.POSTS.LOCKED;
    }

    @Override
    public Field<Boolean> field9() {
        return Posts.POSTS.VISIBLE;
    }

    @Override
    public Field<Long[]> field10() {
        return Posts.POSTS.IMAGES;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public Long component2() {
        return getPoster();
    }

    @Override
    public Long component3() {
        return getBoard();
    }

    @Override
    public Long component4() {
        return getParent();
    }

    @Override
    public LocalDateTime component5() {
        return getCreationtime();
    }

    @Override
    public String component6() {
        return getTitle();
    }

    @Override
    public String component7() {
        return getMessage();
    }

    @Override
    public Boolean component8() {
        return getLocked();
    }

    @Override
    public Boolean component9() {
        return getVisible();
    }

    @Override
    public Long[] component10() {
        return getImages();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public Long value2() {
        return getPoster();
    }

    @Override
    public Long value3() {
        return getBoard();
    }

    @Override
    public Long value4() {
        return getParent();
    }

    @Override
    public LocalDateTime value5() {
        return getCreationtime();
    }

    @Override
    public String value6() {
        return getTitle();
    }

    @Override
    public String value7() {
        return getMessage();
    }

    @Override
    public Boolean value8() {
        return getLocked();
    }

    @Override
    public Boolean value9() {
        return getVisible();
    }

    @Override
    public Long[] value10() {
        return getImages();
    }

    @Override
    public PostsRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public PostsRecord value2(Long value) {
        setPoster(value);
        return this;
    }

    @Override
    public PostsRecord value3(Long value) {
        setBoard(value);
        return this;
    }

    @Override
    public PostsRecord value4(Long value) {
        setParent(value);
        return this;
    }

    @Override
    public PostsRecord value5(LocalDateTime value) {
        setCreationtime(value);
        return this;
    }

    @Override
    public PostsRecord value6(String value) {
        setTitle(value);
        return this;
    }

    @Override
    public PostsRecord value7(String value) {
        setMessage(value);
        return this;
    }

    @Override
    public PostsRecord value8(Boolean value) {
        setLocked(value);
        return this;
    }

    @Override
    public PostsRecord value9(Boolean value) {
        setVisible(value);
        return this;
    }

    @Override
    public PostsRecord value10(Long[] value) {
        setImages(value);
        return this;
    }

    @Override
    public PostsRecord values(Long value1, Long value2, Long value3, Long value4, LocalDateTime value5, String value6, String value7, Boolean value8, Boolean value9, Long[] value10) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PostsRecord
     */
    public PostsRecord() {
        super(Posts.POSTS);
    }

    /**
     * Create a detached, initialised PostsRecord
     */
    public PostsRecord(Long id, Long poster, Long board, Long parent, LocalDateTime creationtime, String title, String message, Boolean locked, Boolean visible, Long[] images) {
        super(Posts.POSTS);

        setId(id);
        setPoster(poster);
        setBoard(board);
        setParent(parent);
        setCreationtime(creationtime);
        setTitle(title);
        setMessage(message);
        setLocked(locked);
        setVisible(visible);
        setImages(images);
    }

    /**
     * Create a detached, initialised PostsRecord
     */
    public PostsRecord(moe.crx.jooq.tables.pojos.Posts value) {
        super(Posts.POSTS);

        if (value != null) {
            setId(value.getId());
            setPoster(value.getPoster());
            setBoard(value.getBoard());
            setParent(value.getParent());
            setCreationtime(value.getCreationtime());
            setTitle(value.getTitle());
            setMessage(value.getMessage());
            setLocked(value.getLocked());
            setVisible(value.getVisible());
            setImages(value.getImages());
        }
    }
}
