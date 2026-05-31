package com.javatpoint.microservice.springjavaprogram.interview2;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public String processPayment(String user){
        System.out.println("Executing Process Payment for User : "+user);
        if("errorUser".equalsIgnoreCase(user)){
            throw new RuntimeException("Payment Processing Failed");
        }
        return "Payment Successful for User : "+user;
    }
}
