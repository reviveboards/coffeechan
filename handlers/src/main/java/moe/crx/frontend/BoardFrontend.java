package moe.crx.frontend;

import com.google.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Feature;
import jakarta.ws.rs.core.FeatureContext;
import jakarta.ws.rs.core.MediaType;
import moe.crx.api.BoardsApi;
import moe.crx.api.PostsApi;
import moe.crx.core.ConfigurationFactory;
import moe.crx.dto.APIError;
import moe.crx.dto.Board;
import moe.crx.html.pages.BoardPage;
import moe.crx.core.Configuration;
import moe.crx.html.pages.MessagePage;
import org.jetbrains.annotations.NotNull;

import static jakarta.ws.rs.core.MediaType.TEXT_HTML;

@Path("/{boardTag}")
@Singleton
public final class BoardFrontend implements Feature {

    private final Configuration config;
    private final BoardsApi boardsApi;
    private final PostsApi postsApi;

    @Inject
    public BoardFrontend(@NotNull ConfigurationFactory configurationFactory,
                         @NotNull BoardsApi boardsApi,
                         @NotNull PostsApi postsApi) {
        this.config = configurationFactory.getInstance();
        this.boardsApi = boardsApi;
        this.postsApi = postsApi;
    }

    @Override
    public boolean configure(FeatureContext context) {
        return true;
    }

    @GET
    @Produces(TEXT_HTML)
    public String board(@PathParam("boardTag") String boardTag) {
        var response = boardsApi.getBoardByTag(boardTag);

        if (!(response instanceof Board board)) {
            return new MessagePage(config)
                    .consumeResponse(response)
                    .html();
        }

        return new BoardPage(config)
                .consumeBoard(board, postsApi)
                .html();
    }

    @GET
    @Path("/post")
    @Produces(TEXT_HTML)
    public String postMessage(@PathParam("boardTag") String boardTag,
                              @QueryParam("postTitle") String postTitle,
                              @QueryParam("postText") String postText) {
        var response = boardsApi.getBoardByTag(boardTag);

        if (!(response instanceof Board board)) {
            return new MessagePage(config)
                    .consumeResponse(response)
                    .html();
        }

        var postResponse = postsApi.postMessage(0, boardTag, 0, postTitle, postText);

        return new BoardPage(config)
                .consumeBoard(board, postsApi)
                .consumeResponse(postResponse)
                .html();
    }

    @GET
    @Path("/{threadId}")
    @Produces(TEXT_HTML)
    public String thread(@PathParam("threadId") long threadId) {
        return new BoardPage(config)
                .html();
    }
}
