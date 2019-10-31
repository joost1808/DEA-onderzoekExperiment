package services.exceptions

import javax.ws.rs.core.Response
import javax.ws.rs.ext.ExceptionMapper
import javax.ws.rs.ext.Provider

@Provider
class IdAlreadyInUseMapper : ExceptionMapper<IdAlreadyInUseException> {
    override fun toResponse(p0: IdAlreadyInUseException?): Response {
        return Response.status(Response.Status.CONFLICT).build()
    }
}