package org.rsys.demowebapp;

import jakarta.ws.rs.*;

@Path("/hello-world")
public class HelloResource {
    @GET
    @Produces("text/plain")
    public String hello() {
        System.out.print("Hello Sonali");

        return "Hello, World!";
    }
    @POST
    @Path("/{name}")
    @Produces("text/plain")
    public String customWelcome(@PathParam("name") String name) {
        System.out.print("Hello Sonali");

        return "Welcome "+ name + "!";
    }
}