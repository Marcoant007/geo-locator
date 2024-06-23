package org.marcoantdev.app.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ApiExceptionHandler implements ExceptionMapper<ApiException> {
    @Override
    public Response toResponse(ApiException exception) {
        return Response.status(exception.getHttpStatus())
                .entity("{\"message\":\"" + exception.getMessage() + "\"}")
                .build();
    }
}
