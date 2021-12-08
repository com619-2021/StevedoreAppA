/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.solent.devops.impl.rest;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uk.ac.solent.devops.model.dto.ReplyMessage;
import uk.ac.solent.devops.model.order.dto.Order;
import uk.ac.solent.devops.model.order.dto.OrderChangeRequest;
import uk.ac.solent.devops.model.order.service.OrderChangeRequestService;
import uk.ac.solent.devops.model.order.service.OrderService;
import uk.ac.solent.devops.model.party.service.PartyService;
import uk.ac.solent.devops.model.resource.service.ResourceCatalogService;
import uk.ac.solent.devops.model.resource.service.ResourceInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author cgallen
 */
@Component // component allows service to be picked up
@Path("/solent-api/order/v1/")
public class OrderChangeRequestRestService {

    final static Logger LOG = LogManager.getLogger(OrderChangeRequestRestService.class);

    @Autowired
    private ResourceCatalogService resourceCatalogService = null;

    @Autowired
    private ResourceInventoryService resourceService = null;

    @Autowired
    private PartyService partyService = null;

    @Autowired
    private OrderService orderService = null;

    @Autowired
    private OrderChangeRequestService orderChangeRequestService = null;

    /*
    @Operation(summary = "Find orderChangeRequest by uuid",
            tags = {"order/orderChangeRequest"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "successful operation returns orderChangeRequest list with one entry", content = @Content(
                            schema = @Schema(implementation = ReplyMessage.class))),
                    @ApiResponse(responseCode = "404", description = "not found"),
                    @ApiResponse(responseCode = "500", description = "internal server error")
            })

     */
    @GET
    @Path("/orderChangeRequest/{uuid}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Transactional(readOnly = true)
    public Response getOrderChangeRequestByuuid(@PathParam("uuid") String uuid, @Context UriInfo uriInfo) {
        try {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        } catch (Exception ex) {
            LOG.error("error calling GET /orderChangeRequest/{uuid} getOrderByuuid uuid=" + uuid, ex);
            ReplyMessage replyMessage = new ReplyMessage();
            replyMessage.setCode(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
            replyMessage.setDebugMessage("error calling GET /orderChangeRequest/{uuid} getOrderByuuid uuid=" + uuid + " " + ex.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(replyMessage).build();
        }
    }
/*
    @Operation(summary = "Delete orderChangeRequest by uuid",
            tags = {"order/orderChangeRequest"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "successful operation returns resource list with one entry", content = @Content(
                            schema = @Schema(implementation = ReplyMessage.class))),
                    @ApiResponse(responseCode = "404", description = "not found"),
                    @ApiResponse(responseCode = "500", description = "internal server error")
            })

 */
    @DELETE
    @Path("/orderChangeRequest/{uuid}")
    @Transactional()
    public Response deleteOrderChangeRequestByUuid(@PathParam("uuid") String uuid, @Context UriInfo uriInfo) {
        try {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        } catch (Exception ex) {
            LOG.error("error calling DELETE /orderChangeRequest/{uuid} getOrderByuuid uuid=" + uuid, ex);
            ReplyMessage replyMessage = new ReplyMessage();
            replyMessage.setCode(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
            replyMessage.setDebugMessage("error calling DELETE /orderChangeRequest/{uuid} getOrderByuuid uuid=" + uuid + " " + ex.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(replyMessage).build();
        }
    }
/*
    @Operation(summary = "Create new Order resource",
            tags = {"order/orderChangeRequest"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "successful operation returns resource list with one entry", content = @Content(
                            schema = @Schema(implementation = ReplyMessage.class))),
                    @ApiResponse(responseCode = "500", description = "internal server error")
            })

 */
    @POST
    @Path("/orderChangeRequest")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Transactional
    public Response postCreateOrderChangeRequest(OrderChangeRequest orderChangeRequest, @Context UriInfo uriInfo) {
        try {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        } catch (Exception ex) {
            LOG.error("error calling POST /orderChangeRequest postCreateOrder ", ex);
            ReplyMessage replyMessage = new ReplyMessage();
            replyMessage.setCode(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
            replyMessage.setDebugMessage("error calling POST /orderChangeRequest postCreateOrder " + ex.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(replyMessage).build();
        }
    }
/*
    @Operation(summary = "update  Order resource",
            tags = {"order/orderChangeRequest"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "successful operation returns resource list with one entry", content = @Content(
                            schema = @Schema(implementation = ReplyMessage.class))),
                    @ApiResponse(responseCode = "404", description = "not found"),
                    @ApiResponse(responseCode = "500", description = "internal server error")
            })

 */
    @PUT
    @Path("/orderChangeRequest")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Transactional
    public Response putUpdateOrderChangeRequest(OrderChangeRequest orderChangeRequest, @Context UriInfo uriInfo) {
        try {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        } catch (Exception ex) {
            LOG.error("error calling PUT /orderChangeRequest putUpdateOrder ", ex);
            ReplyMessage replyMessage = new ReplyMessage();
            replyMessage.setCode(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
            replyMessage.setDebugMessage("error calling PUT /orderChangeRequest putUpdateOrder " + ex.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(replyMessage).build();
        }
    }
/*
    @Operation(summary = "Find orderChangeRequest by resource template",
            tags = {"order/orderChangeRequest"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "successful operation returns orderChangeRequest list with one entry", content = @Content(
                            schema = @Schema(implementation = ReplyMessage.class))),
                    @ApiResponse(responseCode = "404", description = "not found"),
                    @ApiResponse(responseCode = "500", description = "internal server error")
            })

 */

    // note issue - https://github.com/swagger-api/swagger-ui/issues/5388 GET request do not allow a body in swagger UI although supported in JAX-RS
    @GET
    @Path("/orderChangeRequest")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getOrderChangeRequest(@QueryParam("offset") Integer offset, @QueryParam("limit") Integer limit, @Context UriInfo uriInfo) {
        try {
            ReplyMessage replyMessage = orderService.getOrderByTemplate(null, offset, limit);
            replyMessage.setCode(Response.Status.OK.getStatusCode());
            return Response.status(Response.Status.OK).entity(replyMessage).build();
        } catch (Exception ex) {
            LOG.error("error calling GET /orderChangeRequest getOrderByTemplate ", ex);
            ReplyMessage replyMessage = new ReplyMessage();
            replyMessage.setCode(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
            replyMessage.setDebugMessage("error calling GET /orderChangeRequest getOrderByTemplate " + ex.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(replyMessage).build();
        }

    }
/*
    @Operation(summary = "Find orderChangeRequest by resource template (Should be GET but get with resources not allowed in swagger UI)",
            tags = {"order/orderChangeRequest"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "successful operation returns resource list with one entry", content = @Content(
                            schema = @Schema(implementation = ReplyMessage.class))),
                    @ApiResponse(responseCode = "404", description = "not found"),
                    @ApiResponse(responseCode = "500", description = "internal server error")
            })


 */
    // note issue - https://github.com/swagger-api/swagger-ui/issues/5388 GET request do not allow a body in swagger UI although supported in JAX-RS
    @POST
    @Path("/orderChangeRequestByTemplate")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Transactional(readOnly = true)
    public Response getOrderChangeRequestByTemplate(Order orderChangeRequestSearchTemplate, @QueryParam("offset") Integer offset, @QueryParam("limit") Integer limit, @Context UriInfo uriInfo) {

        try {
            ReplyMessage replyMessage = orderChangeRequestService.getOrderChangeRequestByTemplate(orderChangeRequestSearchTemplate, offset, limit);
            replyMessage.setCode(Response.Status.OK.getStatusCode());
            return Response.status(Response.Status.OK).entity(replyMessage).build();

        } catch (Exception ex) {
            LOG.error("error calling GET /getOrderChangeRequestByTemplate getOrderByTemplate ", ex);
            ReplyMessage replyMessage = new ReplyMessage();
            replyMessage.setCode(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
            replyMessage.setDebugMessage("error calling GET /getOrderByTemplate getOrderChangeRequestByTemplate " + ex.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(replyMessage).build();
        }

    }

}