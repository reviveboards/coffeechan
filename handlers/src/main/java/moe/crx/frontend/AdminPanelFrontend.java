package moe.crx.frontend;

import com.google.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Feature;
import jakarta.ws.rs.core.FeatureContext;
import jakarta.ws.rs.core.MediaType;
import moe.crx.api.BoardsApi;
import moe.crx.core.Configuration;
import moe.crx.core.ConfigurationFactory;
import moe.crx.dao.BoardDao;
import moe.crx.dao.CategoryDao;
import moe.crx.frontend.html.pages.AdminPanelPage;
import org.jetbrains.annotations.NotNull;

@Path("/admin")
@Singleton
public final class AdminPanelFrontend implements Feature {

    private final Configuration config;
    private final CategoryDao categoryDao;
    private final BoardDao boardDao;
    private final BoardsApi boardsApi;

    @Inject
    public AdminPanelFrontend(@NotNull ConfigurationFactory configurationFactory,
                              @NotNull BoardDao boardDao,
                              @NotNull CategoryDao categoryDao,
                              @NotNull BoardsApi boardsApi) {
        this.config = configurationFactory.getInstance();
        this.categoryDao = categoryDao;
        this.boardDao = boardDao;
        this.boardsApi = boardsApi;
    }

    @Override
    public boolean configure(FeatureContext context) {
        return true;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String adminPanel() {
        var boardPage = new AdminPanelPage()
                .consumeConfig(config)
                .consumeCategories(categoryDao, boardDao);

        return boardPage.html();
    }

    @GET
    @Path("/createBoard")
    @Produces(MediaType.TEXT_HTML)
    public String createBoard(@QueryParam("name") String name,
                              @QueryParam("tag") String tag) {
        return adminPanel();
    }

    @GET
    @Path("/createCategory")
    @Produces(MediaType.TEXT_HTML)
    public String createCategory(@QueryParam("name") String name) {
        return adminPanel();
    }
}
