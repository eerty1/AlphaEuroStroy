package com.webspace.resource.user;

import com.webspace.crud_service.imageable.CrudServiceImageable;
import com.webspace.model.Portfolio;
import io.quarkus.panache.common.Sort;
import jakarta.annotation.security.PermitAll;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

@Path("/portfolio")
@PermitAll
@RequiredArgsConstructor
public class PortfolioResource {

    protected final CrudServiceImageable<Portfolio> portfolioCrudServiceImageable;
    @GET
    @Path("/default")
    public List<Portfolio> findAll() {
        return portfolioCrudServiceImageable.findAll("dragNdrop", Sort.Direction.Ascending);
    }

    @GET
    public Map<Integer, List<Portfolio>> findALl(@QueryParam("page") int page,
                                                 @QueryParam("size") int size)
    {
        return portfolioCrudServiceImageable.findAll(page, size, "dragNdrop", Sort.Direction.Ascending);
    }

    @GET
    @Path("/{id}")
    public Portfolio findById(@PathParam("id") String id)
    {
        return portfolioCrudServiceImageable.findById(id);
    }
}
