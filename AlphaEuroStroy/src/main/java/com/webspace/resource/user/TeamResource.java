package com.webspace.resource.user;

import com.webspace.crud_service.imageable.CrudServiceImageable;
import com.webspace.model.Team;
import io.quarkus.panache.common.Sort;
import jakarta.annotation.security.PermitAll;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

@Path("/team")
@PermitAll
@RequiredArgsConstructor
public class TeamResource {

    protected final CrudServiceImageable<Team> teamCrudServiceImageable;
    @GET
    @Path("/default")
    public List<Team> findAll() {
        return teamCrudServiceImageable.findAll("dragNdrop", Sort.Direction.Ascending);
    }

    @GET
    public Map<Integer, List<Team>> findALl(@QueryParam("page") int page,
                                            @QueryParam("size") int size)
    {
        return teamCrudServiceImageable.findAll(page, size, "dragNdrop", Sort.Direction.Ascending);
    }

    @GET
    @Path("/{id}")
    public Team findById(@PathParam("id") String id)
    {
        return teamCrudServiceImageable.findById(id);
    }
}