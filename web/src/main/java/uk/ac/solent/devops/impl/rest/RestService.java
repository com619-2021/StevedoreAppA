/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.solent.devops.impl.rest;

/**
 *
 * @author gallenc
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import uk.ac.solent.devops.model.dto.ReplyMessage;
import uk.ac.solent.devops.model.service.ServiceFacade;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * To make the ReST interface easier to program. All of the replies are contained in ReplyMessage classes but only the fields indicated are populated with each
 * reply. All replies will contain a code and a debug message. Possible replies are: List<String> replyMessage.getStringList() AnimalList
 * replyMessage.getAnimalList() int replyMessage.getCode() replyMessage.getDebugMessage(); * @author cgallen
 */
@Component // component allows resource to be picked up
@Path("/service")
public class RestService {

    // SETS UP LOGGING 
    // note that log name will be uk.ac.solent.devops.impl.rest.RestService
    final static Logger LOG = LogManager.getLogger(RestService.class);

    // This serviceFacade object is injected by Spring
    @Autowired(required = true)
    @Qualifier("serviceFacade")
    ServiceFacade serviceFacade = null;

    /**
     * this is a very simple rest test message which only returns a string
     *
     * http://localhost:8080/stevedore/rest/appointmentService/
     *
     * @return String simple message
     */
    // swagger annotations
    /*


    @Operation(
            tags = {"service/test"},
            summary = "all this does is ask for a text 'hello world' response",
            description = "Returns text hello world",
            responses = {
                @ApiResponse(description = "hello world message",
                        content = @Content(mediaType = "text/plain"))
            })
*/
    @GET
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
    @Produces({MediaType.TEXT_PLAIN})
    public String message() {
        LOG.debug("stevedore called");
        return "Hello, rest!";
    }

    /**
     * get heartbeat
     *
     * http://localhost:8080/stevedore/rest/appointmentService/getHeartbeat
     *
     * @return Response OK and heartbeat in debug message
     */
    // Swagger annotations
    /*
    @Operation(
            tags = {"service/test"},
            summary = "This is simply a test method to check there is a heartbeat reply message",
            description = "simply returns an incrimenting heartbeat in debug message",
            responses = {
                @ApiResponse(description = "Heartbeat message in debug message of Reply",
                        content = @Content(
                                schema = @Schema(implementation = ReplyMessage.class)
                        )),
                @ApiResponse(responseCode = "500", description = "Internal server error. See Debug message in response for details")
            })
*/
    @GET
    @Path("/getHeartbeat")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getHeartbeat() {
        try {

            ReplyMessage replyMessage = new ReplyMessage();
            LOG.debug("/getHeartbeat called");

            if (serviceFacade == null) {
                throw new RuntimeException("serviceFacade==null and has not been initialised");
            }

            String heartbeat = serviceFacade.getHeartbeat();
            replyMessage.setDebugMessage(heartbeat);

            replyMessage.setCode(Response.Status.OK.getStatusCode());

            return Response.status(Response.Status.OK).entity(replyMessage).build();

        } catch (Exception ex) {
            LOG.error("error calling /getHeartbeat ", ex);
            ReplyMessage replyMessage = new ReplyMessage();
            replyMessage.setCode(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
            replyMessage.setDebugMessage("error calling /getHeartbeat " + ex.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(replyMessage).build();
        }
    }

}
