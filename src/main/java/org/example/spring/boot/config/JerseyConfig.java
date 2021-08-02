package org.example.spring.boot.config;

import org.example.spring.boot.filters.X1MyContainerRequestFilter;
import org.example.spring.boot.filters.X2MyContainerRequestFilter;
import org.example.spring.boot.filters.X3MyContainerResponseFilter;
import org.example.spring.boot.resources.MyJerseyResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;


@Component
public class JerseyConfig extends ResourceConfig {
	
	public JerseyConfig() {
        register(MyJerseyResource.class);
        register(X1MyContainerRequestFilter.class);
        register(X2MyContainerRequestFilter.class);
        register(X3MyContainerResponseFilter.class);
    }
	
}
