package moe.crx.api;

import com.google.inject.Inject;
import moe.crx.core.ConfigurationFactory;
import moe.crx.dto.Post;
import moe.crx.jooq.tables.records.PostsRecord;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static moe.crx.jooq.Tables.POSTS;

final class PostDao extends AbstractDao<Post, PostsRecord, Long> {

    @Inject
    public PostDao(@NotNull ConfigurationFactory configurationFactory) {
        super(configurationFactory, Post.class, POSTS, POSTS.ID, true);
    }

    public List<Post> getThreads(long boardId) {
        try (var c = getConnection()) {
            return c.context()
                    .fetch(POSTS, POSTS.BOARD.eq(boardId).and(POSTS.PARENT.eq(0L)))
                    .map(r -> r.into(Post.class));
        }
    }
}
