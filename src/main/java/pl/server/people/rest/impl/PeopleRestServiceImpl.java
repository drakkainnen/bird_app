package pl.server.people.rest.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import pl.server.people.rest.api.PeopleRestService;

@Service
public class PeopleRestServiceImpl implements PeopleRestService {

	@Override
	public Response people() {
		List<String> list = Stream.of("Dupa", "blada")//
				.collect(Collectors.toList());
		return Response.ok(list) //
				.build();
	}

}
