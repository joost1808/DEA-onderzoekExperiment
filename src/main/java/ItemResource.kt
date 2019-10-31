import services.ItemService
import services.dto.ItemDTO
import javax.inject.Inject
import javax.inject.Singleton
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Singleton
@Path("/items")
class ItemResource (@Inject val itemService: ItemService) {
//    private val itemService: ItemService? = null
//
//    @Inject
//    fun setItemService(itemService: ItemService) {
//        this.itemService = itemService
//    }

    @GET
    @Produces("text/plain")
    fun itemsText(): String = "bread, butter"

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun itemsJSON(): Response {
        return Response.status(Response.Status.OK).entity(itemService.getAll()).build()
    }

    @Path("{id}")
    @GET
    @Produces("application/json")
    fun itemJSON(@PathParam("id") id: Int): Response {
        return Response.status(Response.Status.OK).entity(itemService.getItem(id)).build()
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    fun addItem(item: ItemDTO): Response {
        itemService.addItem(item)
        return Response.status(Response.Status.CREATED).entity(item).build()
    }

    @Path("/delete/{id}")
    @DELETE
    @Produces("application/json")
    fun deleteItem(@PathParam("id") id: Int): Response {
        itemService.deleteItem(id)
        return Response.status(Response.Status.OK).build()
    }
}