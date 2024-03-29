package moe.crx.api;

import com.google.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Feature;
import jakarta.ws.rs.core.FeatureContext;
import jakarta.ws.rs.core.MediaType;
import moe.crx.dto.APIError;
import moe.crx.dto.Board;
import org.jetbrains.annotations.NotNull;
import org.jooq.exception.DataAccessException;

import java.util.Arrays;
import java.util.List;

@Singleton
@Path("/api/boards")
public final class BoardsApi implements Feature {

    private final BoardDao boardDao;
    private final CategoryDao categoryDao;

    public static final List<String> RESERVED_NAMES = Arrays.asList("admin");

    @Inject
    public BoardsApi(@NotNull BoardDao boardDao,
                     @NotNull CategoryDao categoryDao) {
        this.boardDao = boardDao;
        this.categoryDao = categoryDao;
    }

    @Path("/create")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Object create(@QueryParam("name") String name,
                         @QueryParam("tag") String tag,
                         @QueryParam("parentCategory") long parentCategory,
                         @QueryParam("description") String description) {
        try {
            var category = categoryDao.read(parentCategory);

            if (category == null) {
                return new APIError(0, "No such category");
            }

            if (RESERVED_NAMES.contains(tag)) {
                return new APIError(1, "Specified tag is reserved");
            }

            var board = new Board();
            board.setName(name);
            board.setTag(tag);
            board.setCategory(parentCategory);
            board.setDescription(description);
            board.setVisible(true);

            board = boardDao.create(board);
            if (board == null) {
                return new APIError(0, "Unknown boards error");
            }

            category.getBoards().add(board.getId());
            var update = categoryDao.update(category);
            if (!update) {
                return new APIError(0, "Unknown categories error");
            }

            return board;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return new APIError(0, e.getCause().getMessage());
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Board> boards() {
        return boardDao.all();
    }

    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Board> all() {
        return boards();
    }

    @Override
    public boolean configure(FeatureContext context) {
        return true;
    }

    @Path("/getBoards")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Board> getBoards(@QueryParam("boards") List<Long> boards) {
        return boardDao.readAll(boards);
    }

    @Path("/getBoardByTag")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Object getBoardByTag(@QueryParam("tag") String boardTag) {
        var board = boardDao.readByTag(boardTag);

        if (board == null) {
            return new APIError(0, "Board with specified tag doesn't exist.");
        }

        return board;
    }
}
