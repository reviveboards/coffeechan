package moe.crx.api;

import com.google.inject.AbstractModule;
import moe.crx.database.FlywayFactory;

public final class DatabaseModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(BoardDao.class);
        bind(PostDao.class);
        bind(CategoryDao.class);
        bind(FlywayFactory.class);
    }
}
