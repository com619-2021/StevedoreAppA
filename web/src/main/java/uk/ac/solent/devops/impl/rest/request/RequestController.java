package uk.ac.solent.devops.impl.rest.request;

import org.springframework.stereotype.Component;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import uk.ac.solent.devops.impl.rest.base.ControllerBase;
import uk.ac.solent.devops.model.request.dto.OrderChangeRequest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;

@Component
@Path("/order_change/")
public class RequestController implements ControllerBase<OrderChangeRequest> {


    @POST
    @Override
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public void add(OrderChangeRequest model) {
        throw new NotImplementedException();
    }

    @GET
    @Override
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<OrderChangeRequest> get() {
        return null;
    }

    @GET
    @Override
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public OrderChangeRequest get(@PathParam("id") long id) {
        return null;
    }

    @GET
    @Override
    @Path("/{uuid}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    public OrderChangeRequest get(@PathParam("uuid") UUID uuid) {
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
    public OrderChangeRequest update(OrderChangeRequest updateModel) {
        return null;
    }

}
