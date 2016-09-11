package pl.server.birds.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CustomApplicationExceptionMapper implements ExceptionMapper<CustomException> {

	@Override
	public Response toResponse(CustomException exception) {
		throw exception;
		// return Response.serverError() //
		// .type(MediaType.APPLICATION_JSON) //
		// .entity(exception) //
		// .build();
	}
}
