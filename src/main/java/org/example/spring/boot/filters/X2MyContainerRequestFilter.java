package org.example.spring.boot.filters;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;


/**
 * This filter is executed after the resource was matched
 */
@Provider
public class X2MyContainerRequestFilter implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext ctx) throws IOException {
		//ctx.abortWith(Response.status(Response.Status.FORBIDDEN).entity("Cannot access").build());
		System.out.println("inside ContainerRequestFilter");
	}
	
}
