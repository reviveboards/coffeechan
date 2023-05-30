package moe.crx.handlers;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.multibindings.Multibinder;
import jakarta.ws.rs.core.Feature;
import moe.crx.api.BoardsApi;
import moe.crx.api.CategoriesApi;
import moe.crx.api.PostsApi;
import moe.crx.frontend.AdminPanelFrontend;
import moe.crx.frontend.BoardFrontend;
import moe.crx.frontend.BoardsFrontend;
import org.glassfish.jersey.jackson.JacksonFeature;

import java.util.Set;

public final class HandlersModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(HandlersFactory.class);

        Multibinder<Feature> irestMultibinder = Multibinder.newSetBinder(binder(), Feature.class);
        irestMultibinder.addBinding().to(JacksonFeature.class);
        irestMultibinder.addBinding().to(BoardsApi.class);
        irestMultibinder.addBinding().to(PostsApi.class);
        irestMultibinder.addBinding().to(CategoriesApi.class);
        irestMultibinder.addBinding().to(BoardsFrontend.class);
        irestMultibinder.addBinding().to(BoardFrontend.class);
        irestMultibinder.addBinding().to(AdminPanelFrontend.class);

        Multibinder<IHandlerFactory> factoryMultibinder = Multibinder.newSetBinder(binder(), IHandlerFactory.class);
        factoryMultibinder.addBinding().to(ResourceHandlerFactory.class);
        factoryMultibinder.addBinding().to(ServletContextHandlerFactory.class);
    }

    @Provides
    public Feature[] getRests(Set<Feature> rests) {
        return rests.toArray(new Feature[0]);
    }

    @Provides
    public IHandlerFactory[] getFactories(Set<IHandlerFactory> factories) {
        return factories.toArray(new IHandlerFactory[0]);
    }
}
