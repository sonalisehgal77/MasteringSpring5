package org.rsys.application.context;

import org.apache.log4j.Logger;
import org.rsys.application.Main;
import org.rsys.application.beans.User;
import org.rsys.application.business.BusinessService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "org.rsys.application" })
public class LaunchJavaContext {

    private static final User DUMMY_USER = new User("dummy");

    public static Logger logger = Logger.getLogger(String.valueOf(LaunchJavaContext.class));

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        BusinessService service = context.getBean(BusinessService.class);
        logger.debug("test message: {}"+service.calculateSum(DUMMY_USER));
    }
}
