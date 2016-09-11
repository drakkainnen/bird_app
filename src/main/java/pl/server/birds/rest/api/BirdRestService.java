package pl.server.birds.rest.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/bird")
public interface BirdRestService extends RestService {

	@GET
	List<String> getAllBirds();

	@POST
	@Path("/by-person-name")
	String getBirdByPeronName(String name);

	@GET
	@Path("/brocken")
	String getBrocken();
}