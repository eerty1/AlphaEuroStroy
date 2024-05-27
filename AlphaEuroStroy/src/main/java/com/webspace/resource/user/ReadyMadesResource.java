package com.webspace.resource.user;

import com.webspace.crud_service.imageable.ReadyMadesCrudServiceImageable;
import com.webspace.model.catalog_filter.CatalogFilterValues;
import com.webspace.model.ReadyMades;
import io.quarkus.panache.common.Sort;
import jakarta.annotation.security.PermitAll;
import jakarta.ws.rs.*;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

@Path("/ready-mades")
@PermitAll
@RequiredArgsConstructor
public class ReadyMadesResource {

    protected final ReadyMadesCrudServiceImageable readyMadesCrudService;
    @GET
    @Path("/default")
    public List<ReadyMades> findAll() {
        return readyMadesCrudService.findAll("dragNdrop", Sort.Direction.Ascending);
    }

    @GET
    public Map<Integer, List<ReadyMades>> findALl(@QueryParam("page") int page,
                                                  @QueryParam("size") int size)
    {
        return readyMadesCrudService.findAll(page, size, "dragNdrop", Sort.Direction.Ascending);
    }

    @POST
    @Path("/filter")
    public Map<Integer, List<ReadyMades>> findALl(@QueryParam("page") int page,
                                                  @QueryParam("size") int size,
                                                  CatalogFilterValues catalogFilterValues)
    {
        return readyMadesCrudService.filterCatalog(page, size, catalogFilterValues);
    }

    @GET
    @Path("/{id}")
    public ReadyMades findById(@PathParam("id") String id)
    {
        return readyMadesCrudService.findById(id);
    }

    @GET
    @Path("/filter-properties")
    public List<String> findDistinctPropertyValues(@QueryParam("property") String property) {
        return readyMadesCrudService.findDistinctPropertyValues(property);
    }
}