package se.iths.rest;

import se.iths.entity.Item;
import se.iths.entity.User;
import se.iths.service.ItemService;
import se.iths.service.UserService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserRest {

    @Inject
    UserService userService;

    @Path("new")
    @POST
    public Response createUserm(User user){
        userService.createUser(user);
        return Response.ok(user).build();
    }

    @Path("update")
    @PUT
    public Response updateUser(User user){
        userService.updateUser(user);
        return Response.ok(user).build();
    }

    @Path("{id}")
    @GET
    public Response getUser(@PathParam("id") Long id){
        User foundUser = userService.findUserById(id);
        if( foundUser == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return Response.ok(foundUser).build();
    }

    @Path("all")
    @GET
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @Path("{id}")
    @Produces(MediaType.TEXT_PLAIN)
    @DELETE
    public Response deleteItemById(@PathParam("id") Long id){
        User foundUser = userService.findUserById(id);
        if(foundUser == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return Response.ok().build();
    }

    @Path("items/{id}")
    @GET
    public List<Item> getAllUsers(@PathParam("id") Long id){
        return userService.getAllItemsByUserId(id);
    }
}
