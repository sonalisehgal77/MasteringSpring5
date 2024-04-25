package org.rsys.demowebapp;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Path("/messages")
public class DockerMessageController {
    @GET
    @Produces("text/plain")
    public String getMessage() {
        return "Hello from Docker!";
    }
}
