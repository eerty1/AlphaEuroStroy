package com.webspace.resource.admin;

import com.webspace.crud_service.imageable.CrudServiceImageable;
import com.webspace.model.News;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.jboss.resteasy.reactive.PartType;
import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.multipart.FileUpload;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static com.webspace.image_utils.Directory.NEWS;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/admin/news")
@RolesAllowed({"ADMIN"})
@RequiredArgsConstructor
public class NewsAdminResource {
    protected final CrudServiceImageable<News> newsCrudServiceImageable;

    @POST
    public Response create(@RestForm @PartType(APPLICATION_JSON) News news,
                           @RestForm("images") List<FileUpload> images)
            throws URISyntaxException
    {
        newsCrudServiceImageable.create(news, images, NEWS);
        return Response.created(new URI("/" + news.id)).build();
    }

    @PUT
    public Response update(@RestForm @PartType(APPLICATION_JSON) News news,
                           @RestForm("images") List<FileUpload> images) {
        newsCrudServiceImageable.update(news, images, NEWS);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id) {
        newsCrudServiceImageable.delete(id);
        return Response.ok().build();
    }
}
