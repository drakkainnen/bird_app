package pl.server.people.rest.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/people")
public interface PeopleRestService {

	@GET
	Response people();

}