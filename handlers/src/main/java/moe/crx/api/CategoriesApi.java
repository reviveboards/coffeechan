package moe.crx.api;

import com.google.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Feature;
import jakarta.ws.rs.core.FeatureContext;
import jakarta.ws.rs.core.MediaType;
import moe.crx.dto.APIError;
import moe.crx.dto.Category;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Singleton
@Path("/api/categories")
public final class CategoriesApi implements Feature {

    private final CategoryDao categoryDao;

    @Override
    public boolean configure(FeatureContext context) {
        return true;
    }

    @Inject
    public CategoriesApi(@NotNull CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public Object create(@FormParam("name") String name) {
        if (name == null || name.isBlank()) {
            return new APIError(0, "Name can't be empty");
        }

        var category = new Category();
        category.setName(name);
        category.setVisible(true);

        try {
            category = categoryDao.create(category);
        } catch (Exception e) {
            e.printStackTrace();
            return new APIError(0, e.getCause().getMessage());
        }

        if (category == null) {
            return new APIError(0, "Unknown error");
        }

        return category;
    }

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Category> getAll() {
        return categoryDao.all();
    }
}
