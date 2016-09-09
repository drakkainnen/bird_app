package pl.server.birds.rest.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/bird")
public interface BirdRestService {

	@GET
	Response hello();

	@GET
	@Path("/name/{id}")
	String getBirdName(@PathParam("id") long id);

}