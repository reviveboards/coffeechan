package moe.crx.api;

import com.google.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Feature;
import jakarta.ws.rs.core.FeatureContext;
import jakarta.ws.rs.core.MediaType;
import moe.crx.dto.Post;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Singleton
@Path("/api/posts")
public final class PostsApi implements Feature {

    private final PostDao postDao;

    @Inject
    public PostsApi(@NotNull PostDao postDao) {
        this.postDao = postDao;
    }

    @Override
    public boolean configure(FeatureContext context) {
        return true;
    }

    @GET
    @Path("/getThreads")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Post> getThreads(@QueryParam("board") long boardId) {
        return postDao.getThreads(boardId);
    }
}
