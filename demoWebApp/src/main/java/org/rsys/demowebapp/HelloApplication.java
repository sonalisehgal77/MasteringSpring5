package org.rsys.demowebapp;

//import com.sun.org.slf4j.internal.LoggerFactory;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//extends SpringBootServletInitializer
import java.util.logging.Logger;

@Slf4j
@SpringBootApplication
@ApplicationPath("/api")
public class HelloApplication {

    public static void main(String[] args) {
        Logger.getLogger("Starting...");
        SpringApplication.run(Application.class, args);
    }
}