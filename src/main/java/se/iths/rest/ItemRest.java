package se.iths.rest;

import se.iths.entity.Item;
import se.iths.service.ItemService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("item")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ItemRest {

    @Inject
    ItemService itemService;

    @Path("new")
    @POST
    public Response createItem(Item item){
        itemService.createItem(item);
        return Response.ok(item).build();
    }

    @Path("update")
    @PUT
    public Response updateItem(Item item){
        itemService.updateItem(item);
        return Response.ok(item).build();
    }

    @Path("{id}")
    @GET
    public Response getItem(@PathParam("id") Long id){
        Item foundItem = itemService.findItemById(id);
        return foundItem != null ?
                Response.ok(foundItem)
                        .build()
                :
                Response.status(Response.Status.NOT_FOUND)
                        .entity("Item with ID " + id + " not found.")
                        .type(MediaType.TEXT_PLAIN_TYPE)
                        .build();
    }

    @Path("getall")
    @GET
    public List<Item> getAllItems(){
        return itemService.getAllItems();
    }

    @Path("delete/{id}")
    @DELETE
    public Response deleteItemById(@PathParam("id") Long id){
        itemService.deleteItemById(id);
        return Response.ok().build();
    }

}
