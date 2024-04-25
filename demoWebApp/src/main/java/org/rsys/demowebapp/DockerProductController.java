package org.rsys.demowebapp;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Path("/products")
public class DockerProductController {
    @GET
    public String getMessage() {
        return "A brand new product";
    }
}
