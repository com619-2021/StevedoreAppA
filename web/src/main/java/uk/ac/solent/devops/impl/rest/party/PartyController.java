package uk.ac.solent.devops.impl.rest.party;

import org.springframework.stereotype.Component;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import uk.ac.solent.devops.impl.rest.base.ControllerBase;
import uk.ac.solent.devops.model.party.dto.Party;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;

@Component
@Path("/user/")
public class PartyController implements ControllerBase<Party> {

    @POST
    @Override
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public void add(Party model) {
        throw new NotImplementedException();
    }

    @GET
    @Override
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Party> get() {
        return null;
    }

    @GET
    @Override
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Party get(@PathParam("id") long id) {
        return null;
    }

    @GET
    @Override
    @Path("/{uuid}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    public Party get(@PathParam("uuid") UUID uuid) {
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
    public Party update(Party updateModel) {
        return null;
    }
}
