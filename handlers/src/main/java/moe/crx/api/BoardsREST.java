package moe.crx.api;

import com.google.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Feature;
import jakarta.ws.rs.core.FeatureContext;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import moe.crx.dao.BoardDao;
import moe.crx.dto.Board;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.jetbrains.annotations.NotNull;
import org.jooq.exception.DataAccessException;

import static moe.crx.handlers.Responser.badRequest;
import static moe.crx.handlers.Responser.ok;

@Path("/api/boards")
@Singleton
public final class BoardsREST implements Feature {

    private final BoardDao boardDao;

    @Inject
    public BoardsREST(@NotNull BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    @Path("/create")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@FormDataParam("name") String name,
                           @FormDataParam("tag") String tag) {
        var board = new Board();
        board.setName(name);
        board.setTag(tag);

        try {
            board = boardDao.create(board);
        } catch (DataAccessException e) {
            return badRequest(e.getCause().getMessage());
        }

        if (board == null) {
            return badRequest(null);
        }

        return ok(board);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response boards() {
        return ok(boardDao.all());
    }

    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response all() {
        return boards();
    }

    @Override
    public boolean configure(FeatureContext context) {
        return true;
    }
}
