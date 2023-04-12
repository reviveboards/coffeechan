package moe.crx.api;

import com.google.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Feature;
import jakarta.ws.rs.core.FeatureContext;
import jakarta.ws.rs.core.Response;
import moe.crx.dao.PostDao;
import moe.crx.dto.Post;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.jetbrains.annotations.NotNull;

import static moe.crx.handlers.Responser.badRequest;
import static moe.crx.handlers.Responser.ok;

@Path("/api/posts")
@Singleton
public final class PostsREST implements Feature {

    private final PostDao postDao;

    @Inject
    public PostsREST(@NotNull PostDao postDao) {
        this.postDao = postDao;
    }

    @Override
    public boolean configure(FeatureContext context) {
        return true;
    }

    @GET
    @Path("/create")
    public Response create(@FormDataParam("title") String title,
                           @FormDataParam("message") String message) {
        var post = new Post();
        post.setTitle(title);
        post.setMessage(message);

        try {
            var created = postDao.create(post);

            
        } catch (Exception e) {
            return badRequest(null);
        }

        return ok(null);
    }
}
