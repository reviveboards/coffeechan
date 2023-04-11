/*
 * This file is generated by jOOQ.
 */
package moe.crx.jooq;


import java.util.Arrays;
import java.util.List;

import moe.crx.jooq.tables.Boards;
import moe.crx.jooq.tables.Images;
import moe.crx.jooq.tables.Posts;
import moe.crx.jooq.tables.Users;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Public extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public</code>
     */
    public static final Public PUBLIC = new Public();

    /**
     * The table <code>public.boards</code>.
     */
    public final Boards BOARDS = Boards.BOARDS;

    /**
     * The table <code>public.images</code>.
     */
    public final Images IMAGES = Images.IMAGES;

    /**
     * The table <code>public.posts</code>.
     */
    public final Posts POSTS = Posts.POSTS;

    /**
     * The table <code>public.users</code>.
     */
    public final Users USERS = Users.USERS;

    /**
     * No further instances allowed
     */
    private Public() {
        super("public", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.asList(
            Boards.BOARDS,
            Images.IMAGES,
            Posts.POSTS,
            Users.USERS
        );
    }
}
