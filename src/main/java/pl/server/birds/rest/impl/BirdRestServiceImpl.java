package pl.server.birds.rest.impl;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import pl.server.birds.rest.api.BirdRestService;

@Service(value = "birdRestService")
public class BirdRestServiceImpl implements BirdRestService {

	@Override
	public Response hello() {
		return Response.ok().entity("dupa").build();
	}

	@Override
	public String getBirdName(long id) {
		return Long.toHexString(id);
	}

}
