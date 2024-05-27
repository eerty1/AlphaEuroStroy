package com.webspace.resource.user;

import com.webspace.crud_service.imageable.CrudServiceImageable;
import com.webspace.model.News;
import io.quarkus.panache.common.Sort;
import jakarta.annotation.security.PermitAll;
import jakarta.ws.rs.*;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

@Path("/news")
@PermitAll
@RequiredArgsConstructor
public class NewsResource {

    protected final CrudServiceImageable<News> newsCrudServiceImageable;
    @GET
    @Path("/default")
    public List<News> findAll() {
        return newsCrudServiceImageable.findAll("date", Sort.Direction.Descending);
    }

    @GET
    public Map<Integer, List<News>> findALl(@QueryParam("page") int page,
                                            @QueryParam("size") int size)
    {
        return newsCrudServiceImageable.findAll(page, size, "date", Sort.Direction.Descending);
    }

    @GET
    @Path("/{id}")
    public News findById(@PathParam("id") String id)
    {
        return newsCrudServiceImageable.findById(id);
    }
}
