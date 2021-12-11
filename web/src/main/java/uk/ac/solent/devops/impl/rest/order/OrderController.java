package uk.ac.solent.devops.impl.rest.order;

import org.springframework.stereotype.Component;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import uk.ac.solent.devops.impl.rest.base.ControllerBase;
import uk.ac.solent.devops.model.order.dto.Order;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;

@Component
@Path("/order/")
public class OrderController implements ControllerBase<Order> {

    @POST
    @Override
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public void add(Order model) {
        throw new NotImplementedException();
    }

    @GET
    @Override
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Order> get() {
        return null;
    }

    @GET
    @Override
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Order get(@PathParam("id") long id) {
        return null;
    }

    @GET
    @Override
    @Path("/{uuid}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    public Order get(@PathParam("uuid") UUID uuid) {
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
    public Order update(Order updateModel) {
        return null;
    }
}
