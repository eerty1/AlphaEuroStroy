package com.webspace.resource.admin;

import com.webspace.crud_service.CrudService;
import com.webspace.model.PageModel;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

import java.net.URI;
import java.net.URISyntaxException;

@Path("/admin/page-model")
@RolesAllowed({"ADMIN"})
@RequiredArgsConstructor
public class PageModelAdminResource {

    protected final CrudService<PageModel> pageModelCrudService;

    @POST
    public Response create(PageModel pageModel)
            throws URISyntaxException {
        pageModelCrudService.create(pageModel);
        return Response.created(new URI("/" + pageModel.id)).build();
    }

    @PUT
    public Response update(PageModel pageModel) {
        pageModelCrudService.update(pageModel);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id) {
        pageModelCrudService.delete(id);
        return Response.ok().build();
    }
}
