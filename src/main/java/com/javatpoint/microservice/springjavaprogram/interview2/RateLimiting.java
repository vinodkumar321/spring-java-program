package com.javatpoint.microservice.springjavaprogram.interview2;

public class RateLimiting {
    public static void main(String args[]){

    }
}

class UserRequest {
    private Integer count;
    private Long windowStartTime;

    public UserRequest(Integer count, Long windowStartTime) {
        this.count = count;
        this.windowStartTime = windowStartTime;
    }
}