package moe.crx.handlers;

import jakarta.ws.rs.core.Response;
import moe.crx.dto.APIError;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Responser {

    public static Response ok(@Nullable Object response) {
        return drop(Response.Status.OK, response);
    }

    public static Response drop(@NotNull Response.Status status, @Nullable Object response) {
        return Response
                .status(status)
                .entity(response)
                .build();
    }

    public static Response badRequest(@Nullable String message) {
        return drop(Response.Status.BAD_REQUEST,
                new APIError(Response.Status.BAD_REQUEST.getStatusCode(), message != null ? message : "Bad request."));
    }
}
