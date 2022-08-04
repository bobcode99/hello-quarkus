package org.acme;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.jboss.logging.Logger;

@Path("/")
public class GreetingResource {

    private static final Logger LOG = Logger.getLogger(GreetingResource.class);

    @ConfigProperty(name = "target", defaultValue = "World")
    String message;

    @ConfigProperty(defaultValue = "Students", name="application.greeting.recipient")
    String recipient;


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        LOG.info("hello");
        LOG.debug("done");

        return "Hello " + message + "!";

    }



}