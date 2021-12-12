/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.solent.devops.impl.rest.user;

/**
 *
 * @author gallenc
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import uk.ac.solent.devops.model.user.dto.Role;
import uk.ac.solent.devops.model.user.dto.User;
import uk.ac.solent.devops.model.user.service.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * To make the ReST interface easier to program. All of the replies are contained in ReplyMessage classes but only the fields indicated are populated with each
 * reply. All replies will contain a code and a debug message. Possible replies are: List<String> replyMessage.getStringList() AnimalList
 * replyMessage.getAnimalList() int replyMessage.getCode() replyMessage.getDebugMessage(); * @author cgallen
 */
@Component // component allows resource to be picked up
@Path("/user/")
public class UserRestService {


    final static Logger LOG = LogManager.getLogger(UserRestService.class);

    private final UserService userService;


    public UserRestService(UserService userService) {
        this.userService = userService;
    }

    @GET
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
    @Produces({MediaType.TEXT_PLAIN})
    public String message() {
        LOG.debug("stevedore called");
        return "Hello, rest!";
    }

    @GET
    @Path("/user")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Transactional(readOnly = true)
    public Response getUsers(@Context UriInfo uriInfo) {
        /*
        try {

            ReplyMessage replyMessage = new ReplyMessage();
            LOG.debug("/getUsers called");

            if (userService == null) {
                throw new RuntimeException("userService==null and has not been initialised");
            }

            List<User> userList = userService.findAll();

            String requestPath = uriInfo.getAbsolutePath().toASCIIString();

            List<User> unboundList = unbindUserList(userList, requestPath);

            replyMessage.setUserList(unboundList);
            replyMessage.setLimit(unboundList.size());

            replyMessage.setCode(Response.Status.OK.getStatusCode());

            return Response.status(Response.Status.OK).entity(replyMessage).build();

        } catch (Exception ex) {
            LOG.error("error calling /user getUsers ", ex);
            ReplyMessage replyMessage = new ReplyMessage();
            replyMessage.setCode(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
            replyMessage.setDebugMessage("error calling /user getUsers " + ex.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(replyMessage).build();
        }

         */
        return null;
    }

    @GET
    @Path("/user/{username}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getUser(@PathParam("username") String username, @Context UriInfo uriInfo) {
        /*
        try {

            ReplyMessage replyMessage = new ReplyMessage();
            LOG.debug("/getUser called username=" + username);

            if (userService == null) {
                throw new RuntimeException("userService==null and has not been initialised");
            }

            User user = userService.findByUsername(username);
            if (user == null) {
                replyMessage.setCode(Response.Status.NOT_FOUND.getStatusCode());
                replyMessage.setDebugMessage("username not found " + username);
                replyMessage.setUserList(new ArrayList());
                return Response.status(Response.Status.NOT_FOUND).entity(replyMessage).build();
            }

            String requestPath = uriInfo.getAbsolutePath().toASCIIString();

            List<User> unboundList = unbindUserList(Arrays.asList(user), requestPath);
            replyMessage.setUserList(unboundList);

            replyMessage.setCode(Response.Status.OK.getStatusCode());

            return Response.status(Response.Status.OK).entity(replyMessage).build();

        } catch (Exception ex) {
            LOG.error("error calling /user/{username} getUser username=" + username, ex);
            ReplyMessage replyMessage = new ReplyMessage();
            replyMessage.setCode(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
            replyMessage.setDebugMessage("error calling /user/{username} getUser username=" + username + " error:" + ex.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(replyMessage).build();
        }

         */
        return null;
    }
        
    @POST
    @Path("/user")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Transactional
    public Response createUser(@QueryParam("name") String name, 
            @QueryParam("password") String password,
            @Context UriInfo uriInfo) {
        /*
        try {

            ReplyMessage replyMessage = new ReplyMessage();
            LOG.debug("/createUser called");

            if (userService == null) {
                throw new RuntimeException("userService==null and has not been initialised");
            }
            User user = new User();
            user.setUsername(name);
            user.setFirstName(name);
            user.setSecondName(name);
            user.setPassword(password);
            user = userService.create(user);
            
            List<User> userList = Arrays.asList(user);

            String requestPath = uriInfo.getAbsolutePath().toASCIIString();

            List<User> unboundList = unbindUserList(userList, requestPath);

            replyMessage.setUserList(unboundList);
            replyMessage.setLimit(unboundList.size());

            replyMessage.setCode(Response.Status.OK.getStatusCode());

            return Response.status(Response.Status.OK).entity(replyMessage).build();

        } catch (Exception ex) {
            LOG.error("error calling /user create user ", ex);
            ReplyMessage replyMessage = new ReplyMessage();
            replyMessage.setCode(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
            replyMessage.setDebugMessage("error calling /user create user " + ex.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(replyMessage).build();
        }

         */
        return null;
    }

    public static List<User> unbindUserList(List<User> userList, String requestPath) {
        List<User> unboundList = new ArrayList<>();

        userList.forEach(x -> {
            User newUser = new User();
            unboundList.add(newUser);

            String userName = x.getUsername();

            String href = requestPath.substring(0, requestPath.indexOf("/solent-api/")) + "/solent-api/user/v1/user" + "/" + userName;
            LOG.debug("setting href for username:" + userName + " href=" + href);
            newUser.setHref(href);

            newUser.setEnabled(x.getEnabled());
            newUser.setFirstName(x.getFirstName());
            newUser.setSecondName(x.getSecondName());
            newUser.setUsername(userName);
            newUser.setId(x.getId());


            newUser.setRoles(x.getRoles().stream().map(role -> {
                Role newRole = new Role();
                newRole.setName(role.getName());
                return newRole;
            }).collect(Collectors.toSet()));
        });

        return unboundList;
    }


}
