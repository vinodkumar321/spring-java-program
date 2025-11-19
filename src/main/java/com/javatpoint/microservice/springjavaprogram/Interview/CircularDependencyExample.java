package com.javatpoint.microservice.springjavaprogram.Interview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class CircularDependencyExample {
    public static void main(String args[]){
       // ServiceA serviceA = new ServiceA(new ServiceB());
    }
}

@Service
class ServiceA {
    private final ServiceB serviceB;

    @Autowired
    public ServiceA(ServiceB serviceB){
        this.serviceB = serviceB;
    }
}

@Service
class ServiceB {
    private final ServiceA serviceA;

    @Autowired
    public ServiceB(ServiceA serviceA){
        this.serviceA = serviceA;
    }

}