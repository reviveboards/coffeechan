package moe.crx.dao;

import com.google.inject.Inject;
import com.zaxxer.hikari.HikariDataSource;
import moe.crx.dto.Board;
import moe.crx.jooq.tables.records.BoardsRecord;
import org.jetbrains.annotations.NotNull;

import static moe.crx.jooq.Tables.BOARDS;

public final class BoardDao extends AbstractDao<Board, BoardsRecord, Long> {

    @Inject
    public BoardDao(@NotNull HikariDataSource dataSource) {
        super(Board.class, dataSource, BOARDS, BOARDS.ID, true, BOARDS.TAG);
    }
}
