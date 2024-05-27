package com.webspace.resource.user;

import com.webspace.crud_service.CrudService;
import com.webspace.crud_service.PageModelCrudService;
import com.webspace.model.PageModel;
import io.quarkus.panache.common.Sort;
import jakarta.annotation.security.PermitAll;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

@Path("/page-model")
@PermitAll
@RequiredArgsConstructor
public class PageModelResource {

    protected final CrudService<PageModel> pageModelCrudService;

    @GET
    @Path("/default")
    public List<PageModel> findAll() {
        return pageModelCrudService.findAll("pageName", Sort.Direction.Ascending);
    }

    @GET
    public Map<Integer, List<PageModel>> findALl(@QueryParam("page") int page,
                                                 @QueryParam("size") int size)
    {
        return pageModelCrudService.findAll(page, size, "pageName", Sort.Direction.Ascending);
    }

    @GET
    @Path("/{id}")
    public PageModel findById(@PathParam("id") String id)
    {
        return pageModelCrudService.findById(id);
    }

    @GET
    @Path("/name/{pageName}")
    public PageModel findByPageName(@PathParam("pageName") String pageName) {
        return ((PageModelCrudService) pageModelCrudService).findByPageName(pageName);
    }
}
