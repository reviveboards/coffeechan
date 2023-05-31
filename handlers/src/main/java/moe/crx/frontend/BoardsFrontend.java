package moe.crx.frontend;

import com.google.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.*;
import moe.crx.api.BoardsApi;
import moe.crx.api.CategoriesApi;
import moe.crx.core.Configuration;
import moe.crx.core.ConfigurationFactory;
import moe.crx.html.pages.BoardsPage;
import org.jetbrains.annotations.NotNull;

@Path("/")
@Singleton
public final class BoardsFrontend implements Feature {

    private final BoardsApi boardsApi;
    private final CategoriesApi categoriesApi;
    private final Configuration config;

    @Inject
    public BoardsFrontend(@NotNull BoardsApi boardsApi,
                          @NotNull CategoriesApi categoriesApi,
                          @NotNull ConfigurationFactory configurationFactory) {
        this.boardsApi = boardsApi;
        this.categoriesApi = categoriesApi;
        this.config = configurationFactory.getInstance();
    }

    @Override
    public boolean configure(FeatureContext context) {
        return true;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String index() {
        return new BoardsPage(config)
                .consumeBoards(categoriesApi, boardsApi)
                .html();
    }


    @Path("/boards")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String boards() {
        return index();
    }
}
