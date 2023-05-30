package moe.crx.database;

import com.google.inject.AbstractModule;
import moe.crx.dao.BoardDao;
import moe.crx.dao.PostDao;

public final class DatabaseModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(BoardDao.class);
        bind(PostDao.class);
        bind(FlywayFactory.class);
    }
}
