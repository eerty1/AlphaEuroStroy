package com.webspace.exception.exception_mapper;

import com.webspace.exception.ImagePersistenceException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import static jakarta.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR;

@Provider
public class ImagePersistenceExceptionMapper implements ExceptionMapper<ImagePersistenceException> {
    @Override
    public Response toResponse(ImagePersistenceException imagePersistenceException) {
        return Response.status(INTERNAL_SERVER_ERROR).entity(imagePersistenceException.getMessage()).build();
    }
}
