package moe.crx.frontend;

import com.google.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Feature;
import jakarta.ws.rs.core.FeatureContext;
import jakarta.ws.rs.core.MediaType;
import moe.crx.api.BoardsApi;
import moe.crx.api.CategoriesApi;
import moe.crx.core.Configuration;
import moe.crx.core.ConfigurationFactory;
import moe.crx.html.pages.AdminPanelPage;
import org.jetbrains.annotations.NotNull;

@Path("/admin")
@Singleton
public final class AdminPanelFrontend implements Feature {

    private final Configuration config;
    private final BoardsApi boardsApi;
    private final CategoriesApi categoriesApi;

    @Inject
    public AdminPanelFrontend(@NotNull ConfigurationFactory configurationFactory,
                              @NotNull BoardsApi boardsApi,
                              @NotNull CategoriesApi categoriesApi) {
        this.config = configurationFactory.getInstance();
        this.boardsApi = boardsApi;
        this.categoriesApi = categoriesApi;
    }

    @Override
    public boolean configure(FeatureContext context) {
        return true;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String adminPanel() {
        return new AdminPanelPage(config)
                .consumeCategories(categoriesApi, boardsApi)
                .html();
    }

    @GET
    @Path("/createBoard")
    @Produces(MediaType.TEXT_HTML)
    public String createBoard(@QueryParam("name") String name,
                              @QueryParam("tag") String tag,
                              @QueryParam("description") String description,
                              @QueryParam("parentCategory") long parentCategory) {
        var response = boardsApi.create(name, tag, parentCategory, description);

        return new AdminPanelPage(config)
                .consumeCategories(categoriesApi, boardsApi)
                .consumeResponse(response)
                .html();
    }

    @GET
    @Path("/createCategory")
    @Produces(MediaType.TEXT_HTML)
    public String createCategory(@QueryParam("name") String name) {
        var response = categoriesApi.create(name);

        return new AdminPanelPage(config)
                .consumeCategories(categoriesApi, boardsApi)
                .consumeResponse(response)
                .html();
    }
}
