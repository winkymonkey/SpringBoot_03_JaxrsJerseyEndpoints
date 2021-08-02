package org.example.spring.boot.filters;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;


/**
 * This filter is executed after Resource class is executed
 * Notice that the ContainerRequestContext parameter is just used as read-only – since we're already processing the response.
 */
@Provider
public class X3MyContainerResponseFilter implements ContainerResponseFilter {
	
	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
		//responseContext.getHeaders().add("X-Test", "Filter test");	To add custom header
		System.out.println("inside ContainerResponseFilter");
	}
	
}
