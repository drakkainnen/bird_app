package pl.server.people.config.proxy;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.apache.cxf.jaxrs.client.ResponseExceptionMapper;

import pl.server.birds.exceptions.CustomException;

@Provider
public class CustomResponseMapper implements ResponseExceptionMapper<CustomException> {

	@Override
	public CustomException fromResponse(Response resp) {
		CustomException entity = resp.readEntity(CustomException.class);
		entity = new CustomException(entity.getMessage() + "mapped");
		return entity;
	}

}
