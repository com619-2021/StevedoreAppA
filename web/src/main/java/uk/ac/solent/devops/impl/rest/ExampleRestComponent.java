package uk.ac.solent.devops.impl.rest;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.List;

@Component //Component to the Father class RestApp
@Path("/example") //Path after the ApplicationPath
public class ExampleRestComponent {

    @GET //HTTP Methods
    @Path("/example/{uuid}") //braces with PathParams can be accessed by @PathParam annotation
    @Consumes({MediaType.APPLICATION_JSON}) //Input body type | only allows json input
    @Produces({MediaType.APPLICATION_JSON}) //Output type
    @Transactional(readOnly = true) //Any failure causes the entire operation to roll back to its previous state and to re-throw the original exception (readOnly is for retrieving data only)
    public String getExampleByUuid(@PathParam("uuid") String uuid, @Context UriInfo uriInfo) {
        return "";
    }

    @GET
    @Path("/example")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Transactional(readOnly = true)
    public List<String> getAll(@Context UriInfo uriInfo) {
        return new ArrayList<>();
    }

    @DELETE
    @Path("/example/{uuid}")
    @Transactional
    public String deleteResourceCatalogByUuid(@PathParam("uuid") String uuid, @Context UriInfo uriInfo) {
        return "";
    }

}
