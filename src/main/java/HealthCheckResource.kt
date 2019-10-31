import javax.ws.rs.GET
import javax.ws.rs.Path

@Path("/health")
class HealthCheckResource {

    @GET
    fun healthy() : String {
        return "Up & Running"
    }
}