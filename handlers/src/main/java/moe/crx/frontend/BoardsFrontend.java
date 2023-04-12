package moe.crx.frontend;

import com.google.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.*;
import moe.crx.core.Configuration;
import moe.crx.core.ConfigurationFactory;
import moe.crx.dao.BoardDao;
import moe.crx.frontend.html.pages.BoardsPage;
import org.jetbrains.annotations.NotNull;

import static moe.crx.handlers.Responser.ok;

@Path("/boards")
@Singleton
public final class BoardsFrontend implements Feature {

    private final BoardDao boardDao;
    private final Configuration config;

    @Inject
    public BoardsFrontend(@NotNull BoardDao boardDao,
                          @NotNull ConfigurationFactory configurationFactory) {
        this.boardDao = boardDao;
        this.config = configurationFactory.getInstance();
    }

    @Override
    public boolean configure(FeatureContext context) {
        return true;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response boards() {
        var boardsPage = new BoardsPage().consumeBoards(boardDao.all()).consumeConfig(config);

        return ok(boardsPage.html());
    }
}
