package services.exceptions

import javax.ws.rs.core.Response
import javax.ws.rs.ext.ExceptionMapper

class ItemNotAvailableMapper : ExceptionMapper<ItemNotAvailableException> {
    override fun toResponse(p0: ItemNotAvailableException?): Response {
        return Response.status(Response.Status.NOT_FOUND).build()
    }
}