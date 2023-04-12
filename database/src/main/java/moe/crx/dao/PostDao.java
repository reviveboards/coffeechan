package moe.crx.dao;

import com.google.inject.Inject;
import com.zaxxer.hikari.HikariDataSource;
import moe.crx.dto.Post;
import moe.crx.jooq.tables.records.PostsRecord;
import org.jetbrains.annotations.NotNull;

import static moe.crx.jooq.Tables.POSTS;

public final class PostDao extends AbstractDao<Post, PostsRecord, Long> {

    @Inject
    public PostDao(@NotNull HikariDataSource dataSource) {
        super(Post.class, dataSource, POSTS, POSTS.ID, true);
    }
}
