package pl.server.people.rest.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import pl.server.birds.exceptions.CustomException;
import pl.server.birds.rest.api.RestService;

@Path("/people")
public interface PeopleRestService extends RestService {

	@GET
	List<String> people();

	@GET
	@Path("/{id}/birds")
	String personWithBirds(@PathParam("id") int id);

	@GET
	@Path("/brocken")
	default String brockenPerson() {
		throw new CustomException("brocken");
	}

}