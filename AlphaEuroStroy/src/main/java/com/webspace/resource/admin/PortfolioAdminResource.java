package com.webspace.resource.admin;

import com.webspace.crud_service.imageable.CrudServiceImageable;
import com.webspace.model.Portfolio;
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

import static com.webspace.image_utils.Directory.PORTFOLIO;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/admin/portfolio")
@RolesAllowed({"ADMIN"})
@RequiredArgsConstructor
public class PortfolioAdminResource {
    protected final CrudServiceImageable<Portfolio> portfolioCrudServiceImageable;

    @POST
    public Response create(@RestForm @PartType(APPLICATION_JSON) Portfolio portfolio,
                           @RestForm("images") List<FileUpload> images)
            throws URISyntaxException
    {
        portfolioCrudServiceImageable.create(portfolio, images, PORTFOLIO);
        return Response.created(new URI("/" + portfolio.id)).build();
    }

    @PUT
    public Response update(@RestForm @PartType(APPLICATION_JSON) Portfolio portfolio,
                           @RestForm("images") List<FileUpload> images) {
        portfolioCrudServiceImageable.update(portfolio, images, PORTFOLIO);
        return Response.ok().build();
    }

    @PUT
    @Path("/order")
    public Response changeOrder(List<Portfolio> portfolios) {
        portfolioCrudServiceImageable.changeOrder(portfolios);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id) {
        portfolioCrudServiceImageable.delete(id);
        return Response.ok().build();
    }
}
