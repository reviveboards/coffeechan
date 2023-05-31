package moe.crx.dao;

import com.google.inject.Inject;
import moe.crx.core.ConfigurationFactory;
import moe.crx.dto.Board;
import moe.crx.jooq.tables.records.BoardsRecord;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static moe.crx.jooq.Tables.BOARDS;

public final class BoardDao extends AbstractDao<Board, BoardsRecord, Long> {

    @Inject
    public BoardDao(@NotNull ConfigurationFactory configurationFactory) {
        super(configurationFactory, Board.class, BOARDS, BOARDS.ID, true, BOARDS.TAG);
    }

    public @Nullable Board readByTag(@NotNull String tag) {
        return readBy(BOARDS.TAG, tag);
    }
}
