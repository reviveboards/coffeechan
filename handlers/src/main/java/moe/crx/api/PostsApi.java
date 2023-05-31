package moe.crx.api;

import com.google.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Feature;
import jakarta.ws.rs.core.FeatureContext;
import jakarta.ws.rs.core.MediaType;
import moe.crx.dto.APIError;
import moe.crx.dto.Post;
import org.jetbrains.annotations.NotNull;

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

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public Object create(@FormParam("title") String title,
                         @FormParam("message") String message) {
        var post = new Post();
        post.setTitle(title);
        post.setMessage(message);

        try {
            var created = postDao.create(post);
            return created;
        } catch (Exception e) {
            e.printStackTrace();
            return new APIError();
        }
    }
}
