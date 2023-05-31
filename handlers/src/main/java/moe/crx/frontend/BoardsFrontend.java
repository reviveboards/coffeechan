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
import moe.crx.dao.CategoryDao;
import moe.crx.html.pages.BoardsPage;
import org.jetbrains.annotations.NotNull;

@Path("/")
@Singleton
public final class BoardsFrontend implements Feature {

    private final BoardDao boardDao;
    private final CategoryDao categoryDao;
    private final Configuration config;

    @Inject
    public BoardsFrontend(@NotNull BoardDao boardDao,
                          @NotNull CategoryDao categoryDao,
                          @NotNull ConfigurationFactory configurationFactory) {
        this.boardDao = boardDao;
        this.categoryDao = categoryDao;
        this.config = configurationFactory.getInstance();
    }

    @Override
    public boolean configure(FeatureContext context) {
        return true;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String index() {
        return new BoardsPage()
                .consumeBoards(categoryDao, boardDao)
                .consumeConfig(config)
                .html();
    }


    @Path("/boards")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String boards() {
        return index();
    }
}
