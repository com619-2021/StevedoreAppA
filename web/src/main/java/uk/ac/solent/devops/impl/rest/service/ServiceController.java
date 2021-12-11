package uk.ac.solent.devops.impl.rest.service;

import org.springframework.stereotype.Component;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import uk.ac.solent.devops.impl.rest.base.ControllerBase;
import uk.ac.solent.devops.model.service.dto.ServiceModel;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;

@Component
@Path("/service/")
public class ServiceController implements ControllerBase<ServiceModel> {

    @POST
    @Override
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public void add(ServiceModel model) {
        throw new NotImplementedException();
    }

    @GET
    @Override
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ServiceModel> get() {
        return null;
    }

    @GET
    @Override
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ServiceModel get(@PathParam("id") long id) {
        return null;
    }

    @GET
    @Override
    @Path("/{uuid}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    public ServiceModel get(@PathParam("uuid") UUID uuid) {
        return null;
    }

    @DELETE
    @Override
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    public void delete(@PathParam("id") long id) {

    }

    @DELETE
    @Override
    @Path("/{uuid}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    public void delete(@PathParam("uuid") UUID id) {

    }


    @PUT
    @Override
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    public ServiceModel update(ServiceModel updateModel) {
        return null;
    }
}
