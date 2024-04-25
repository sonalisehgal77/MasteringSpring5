package org.rsys.application.context;

import org.apache.log4j.Logger;
import org.rsys.application.business.BusinessService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.rsys.application.beans.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "org.rsys.application" })
public class LaunchXmlContext {

    private static final User DUMMY_USER = new User("dummy");

    public static Logger logger = Logger.getLogger(LaunchJavaContext.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "BusinessApplicationContext.xml");

        BusinessService service = context.getBean(BusinessService.class);
        logger.debug("calculateSUM : {}"+service.calculateSum(DUMMY_USER));
    }

}