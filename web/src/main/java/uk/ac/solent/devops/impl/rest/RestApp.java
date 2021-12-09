package uk.ac.solent.devops.impl.rest;


import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/rest/v1")
public class RestApp extends ResourceConfig {

    public RestApp() {

    }
}
