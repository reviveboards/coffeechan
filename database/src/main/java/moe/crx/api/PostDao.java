package moe.crx.api;

import com.google.inject.Inject;
import moe.crx.core.ConfigurationFactory;
import moe.crx.dto.Post;
import moe.crx.jooq.tables.records.PostsRecord;
import org.jetbrains.annotations.NotNull;

import static moe.crx.jooq.Tables.POSTS;

final class PostDao extends AbstractDao<Post, PostsRecord, Long> {

    @Inject
    public PostDao(@NotNull ConfigurationFactory configurationFactory) {
        super(configurationFactory, Post.class, POSTS, POSTS.ID, true);
    }
}
