package pl.server.people.rest.api;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

@Service
@Path("/people")
public class PeopleRestServiceImpl {

	@GET
	public Response people() {
		return Response.ok(Stream.of("Dupa", "blada").collect(Collectors.toList())).build();
	}

}
