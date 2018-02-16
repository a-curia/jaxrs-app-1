package com.dbbyte.rest.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.dbbyte.rest.error.ErrorMessage;


@Provider // registers this to JAX-RS
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException ex) {
		// cutom response in case of exception
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 404, "aaaaaaa link");
		
		return Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
	}

}
