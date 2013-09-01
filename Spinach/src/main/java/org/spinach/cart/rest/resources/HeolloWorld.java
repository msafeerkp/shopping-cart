package org.spinach.cart.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

@Component
@Path("/hello")
public class HeolloWorld {

	@GET
	@Path("/sayhello")
	public Response sayHello() {
		return Response.status(200).entity("Hello").build();
	}
}
