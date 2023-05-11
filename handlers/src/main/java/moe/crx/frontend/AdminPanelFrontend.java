package moe.crx.frontend;

import com.google.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Feature;
import jakarta.ws.rs.core.FeatureContext;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import moe.crx.api.BoardsREST;
import moe.crx.core.Configuration;
import moe.crx.core.ConfigurationFactory;
import moe.crx.frontend.html.pages.AdminPanelPage;
import org.jetbrains.annotations.NotNull;

import static moe.crx.handlers.Responser.ok;

@Path("/admin")
@Singleton
public final class AdminPanelFrontend implements Feature {

    private final Configuration config;
    private final BoardsREST boardsREST;

    @Inject
    public AdminPanelFrontend(@NotNull ConfigurationFactory configurationFactory, @NotNull BoardsREST boardsREST) {
        this.config = configurationFactory.getInstance();
        this.boardsREST = boardsREST;
    }

    @Override
    public boolean configure(FeatureContext context) {
        return true;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response adminPanel() {
        var boardPage = new AdminPanelPage().consumeConfig(config);

        return ok(boardPage.html());
    }

    @GET
    @Path("/createboard")
    @Produces(MediaType.TEXT_HTML)
    public Response createBoard(@QueryParam("name") String name, @QueryParam("tag") String tag) {
        try (var resp = boardsREST.create(name, tag)) {
            return ok(new AdminPanelPage().consumeConfig(config).html());
        }
    }
}
