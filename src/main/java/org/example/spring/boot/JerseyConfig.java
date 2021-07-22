package org.example.spring.boot;

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
