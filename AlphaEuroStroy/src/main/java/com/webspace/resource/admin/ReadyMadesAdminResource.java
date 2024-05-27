package com.webspace.resource.admin;

import com.webspace.crud_service.imageable.CrudServiceImageable;
import com.webspace.model.ReadyMades;
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

import static com.webspace.image_utils.Directory.READY_MADES;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/admin/ready-mades")
@RolesAllowed({"ADMIN"})
@RequiredArgsConstructor
public class ReadyMadesAdminResource {
    protected final CrudServiceImageable<ReadyMades> readyMadesCrudServiceImageable;

    @POST
    public Response create(@RestForm @PartType(APPLICATION_JSON) ReadyMades readyMades,
                           @RestForm("images") List<FileUpload> images)
            throws URISyntaxException
    {
        readyMadesCrudServiceImageable.create(readyMades, images, READY_MADES);
        return Response.created(new URI("/" + readyMades.id)).build();
    }

    @PUT
    public Response update(@RestForm @PartType(APPLICATION_JSON) ReadyMades readyMades,
                           @RestForm("images") List<FileUpload> images) {
        readyMadesCrudServiceImageable.update(readyMades, images, READY_MADES);
        return Response.ok().build();
    }

    @PUT
    @Path("/order")
    public Response changeOrder(List<ReadyMades> readyMades) {
        readyMadesCrudServiceImageable.changeOrder(readyMades);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id) {
        readyMadesCrudServiceImageable.delete(id);
        return Response.ok().build();
    }
}