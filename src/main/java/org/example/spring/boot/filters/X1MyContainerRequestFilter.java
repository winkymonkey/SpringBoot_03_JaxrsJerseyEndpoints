package org.example.spring.boot.filters;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;


/**
 * This filter is executed even BEFORE the resource is matched
 */
@Provider
@PreMatching
public class X1MyContainerRequestFilter implements ContainerRequestFilter {
	
	@Override
    public void filter(ContainerRequestContext ctx) throws IOException {
        System.out.println("inside ContainerRequestFilter (pre-matching)");
    }
	
}
