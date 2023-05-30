package moe.crx.dao;

import com.google.inject.Inject;
import moe.crx.core.ConfigurationFactory;
import moe.crx.dto.Category;
import moe.crx.jooq.tables.records.CategoriesRecord;
import org.jetbrains.annotations.NotNull;

import static moe.crx.jooq.Tables.CATEGORIES;

public final class CategoryDao extends AbstractDao<Category, CategoriesRecord, Long> {

    @Inject
    public CategoryDao(@NotNull ConfigurationFactory configurationFactory) {
        super(configurationFactory, Category.class, CATEGORIES, CATEGORIES.ID, true);
    }
}
