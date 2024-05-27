package com.webspace.resource.admin;

import com.webspace.crud_service.imageable.CrudServiceImageable;
import com.webspace.model.Team;
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

import static com.webspace.image_utils.Directory.TEAM;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/admin/team")
@RolesAllowed({"ADMIN"})
@RequiredArgsConstructor
public class TeamAdminResource {
    protected final CrudServiceImageable<Team> teamCrudServiceImageable;

    @POST
    public Response create(@RestForm @PartType(APPLICATION_JSON) Team team,
                           @RestForm("images") List<FileUpload> images)
            throws URISyntaxException
    {
        teamCrudServiceImageable.create(team, images, TEAM);
        return Response.created(new URI("/" + team.id)).build();
    }

    @PUT
    public Response update(@RestForm @PartType(APPLICATION_JSON) Team team,
                           @RestForm("images") List<FileUpload> images) {
        teamCrudServiceImageable.update(team, images, TEAM);
        return Response.ok().build();
    }

    @PUT
    @Path("/order")
    public Response changeOrder(List<Team> team) {
        teamCrudServiceImageable.changeOrder(team);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id) {
        teamCrudServiceImageable.delete(id);
        return Response.ok().build();
    }
}