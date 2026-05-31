package com.javatpoint.microservice.springjavaprogram.interview2;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.core.parameters.P;

public class SpringAOPExample {

    public static void main(String args[]){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PaymentService service = context.getBean(PaymentService.class);
        service.processPayment("Vinod");
    }
}


