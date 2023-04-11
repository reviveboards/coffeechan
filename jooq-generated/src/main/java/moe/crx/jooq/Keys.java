/*
 * This file is generated by jOOQ.
 */
package moe.crx.jooq;


import moe.crx.jooq.tables.Boards;
import moe.crx.jooq.tables.Images;
import moe.crx.jooq.tables.Posts;
import moe.crx.jooq.tables.Users;
import moe.crx.jooq.tables.records.BoardsRecord;
import moe.crx.jooq.tables.records.ImagesRecord;
import moe.crx.jooq.tables.records.PostsRecord;
import moe.crx.jooq.tables.records.UsersRecord;

import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<BoardsRecord> BOARDS_PK = Internal.createUniqueKey(Boards.BOARDS, DSL.name("boards_pk"), new TableField[] { Boards.BOARDS.ID }, true);
    public static final UniqueKey<BoardsRecord> BOARDS_TAG_KEY = Internal.createUniqueKey(Boards.BOARDS, DSL.name("boards_tag_key"), new TableField[] { Boards.BOARDS.TAG }, true);
    public static final UniqueKey<ImagesRecord> IMAGES_PK = Internal.createUniqueKey(Images.IMAGES, DSL.name("images_pk"), new TableField[] { Images.IMAGES.ID }, true);
    public static final UniqueKey<PostsRecord> POSTS_PK = Internal.createUniqueKey(Posts.POSTS, DSL.name("posts_pk"), new TableField[] { Posts.POSTS.ID }, true);
    public static final UniqueKey<UsersRecord> USERS_PK = Internal.createUniqueKey(Users.USERS, DSL.name("users_pk"), new TableField[] { Users.USERS.ID }, true);
}
