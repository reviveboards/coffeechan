package moe.crx.dao;

import com.google.inject.Inject;
import moe.crx.core.Configuration;
import moe.crx.dto.Post;
import moe.crx.jooq.tables.records.PostsRecord;
import org.jetbrains.annotations.NotNull;

import static moe.crx.jooq.Tables.POSTS;

public final class PostDao extends AbstractDao<Post, PostsRecord, Long> {

    @Inject
    public PostDao(@NotNull Configuration config) {
        super(config, Post.class, POSTS, POSTS.ID, true);
    }
}
