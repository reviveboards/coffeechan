package moe.crx.frontend.html.components;

import moe.crx.dto.Board;
import moe.crx.frontend.html.AbstractComponent;
import org.jetbrains.annotations.NotNull;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public final class BoardListEntry extends AbstractComponent<BoardListEntry> {

    private static final Element BASE;

    static {
        try {
            BASE = Jsoup.parse(BoardList.class.getResourceAsStream("/frontend/components/board_list_entry.html"), "UTF-8", "").child(0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public BoardListEntry() {
        super(BASE);
    }

    public @NotNull BoardListEntry consumeBoard(@NotNull Board board) {
        getElement().getElementsByClass("coffeechan#boardLink").forEach(element ->
                element.attr("href", "/" + board.getTag()));
        getElement().getElementsByClass("coffeechan#boardTagSlashed").forEach(element ->
                element.append("/" + board.getTag() + "/"));
        getElement().getElementsByClass("coffeechan#boardTag").forEach(element ->
                element.append(board.getTag()));
        getElement().getElementsByClass("coffeechan#boardName").forEach(element ->
                element.append(board.getName()));

        return this;
    }
}
