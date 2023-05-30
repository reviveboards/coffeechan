package moe.crx.api;

import com.google.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Feature;
import jakarta.ws.rs.core.FeatureContext;
import jakarta.ws.rs.core.MediaType;
import moe.crx.dao.BoardDao;
import moe.crx.dto.APIError;
import moe.crx.dto.Board;
import org.jetbrains.annotations.NotNull;
import org.jooq.exception.DataAccessException;

import java.util.List;

@Singleton
@Path("/api/boards")
public final class BoardsApi implements Feature {

    private final BoardDao boardDao;

    @Inject
    public BoardsApi(@NotNull BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    @Path("/create")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Object create(@FormParam("name") String name,
                         @FormParam("tag") String tag) {
        var board = new Board();
        board.setName(name);
        board.setTag(tag);

        try {
            board = boardDao.create(board);
        } catch (DataAccessException e) {
            return new APIError(0, e.getCause().getMessage());
        }

        if (board == null) {
            return new APIError(0, "Unknown error");
        }

        return board;
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
}
