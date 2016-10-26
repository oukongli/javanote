package com.shdev.demo.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * Created by ou_ko on 2016/8/5.
 */
@Path("/example")
@Produces("application/json")
public interface ExampleService {
    @GET
    @Path("/{id}")
    ExampleModel get(@PathParam("id") String id);

    @GET
    @Path("/all/{id}")
    List<ExampleModel> getAll(@PathParam("id") String id);
}
