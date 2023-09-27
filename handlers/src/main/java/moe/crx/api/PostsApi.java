package moe.crx.api;

import com.google.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Feature;
import jakarta.ws.rs.core.FeatureContext;
import moe.crx.dto.APIError;
import moe.crx.dto.Post;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Singleton
@Path("/api/posts")
public final class PostsApi implements Feature {

    private final PostDao postDao;
    private final BoardDao boardDao;

    @Inject
    public PostsApi(@NotNull PostDao postDao,
                    @NotNull BoardDao boardDao) {
        this.postDao = postDao;
        this.boardDao = boardDao;
    }

    @Override
    public boolean configure(FeatureContext context) {
        return true;
    }

    @GET
    @Path("/getThreads")
    @Produces(APPLICATION_JSON)
    public List<Post> getThreads(@QueryParam("board") long boardId) {
        return postDao.getThreads(boardId);
    }

    @GET
    @Path("/postMessage")
    @Produces(APPLICATION_JSON)
    public Object postMessage(@QueryParam("boardId") long boardId,
                              @QueryParam("boardTag") String boardTag,
                              @QueryParam("parent") long parentPost,
                              @QueryParam("title") String title,
                              @QueryParam("message") String message) {
        if (boardId == 0 && (boardTag == null || boardTag.isBlank())) {
            return new APIError(1, "Specify boardId or boardTag");
        }

        var board = boardId == 0 ? null : boardDao.read(boardId);
        if (board == null) {
            board = boardTag == null ? null : boardDao.readByTag(boardTag);
        }

        if (board == null) {
            return new APIError(1, "Board is not found");
        }

        if (message == null || message.isBlank()) {
            return new APIError(1, "Message is empty");
        }

        var created = new Post();
        created.setBoard(board.getId());
        created.setParent(parentPost);
        created.setTitle(title);
        created.setMessage(message);

        created = postDao.create(created);
        if (created == null) {
            return new APIError(0, "Unknown database error");
        }

        return created;
    }
}
