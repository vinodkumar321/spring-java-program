package com.javatpoint.microservice.springjavaprogram.interview2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectClass {

   @Before("execution(* com.javatpoint.microservice.springjavaprogram.interview2.PaymentService.*(..))")
   public void beforeAdvice() {
       System.out.println("before Payment Method Execution");
   }

    @After("execution(* com.javatpoint.microservice.springjavaprogram.interview2.PaymentService.*(..))")
    public void afterAdvice() {
        System.out.println("After Payment Method Execution");
    }

    @AfterReturning(pointcut = "execution(* com.javatpoint.microservice.springjavaprogram.interview2.PaymentService.*(..))" , returning = "result")
    public void afterReturnSuccessAdvice(Object result) {
        System.out.println("Payment Method Returns : "+result);
    }

    @AfterThrowing(pointcut = "execution(* com.javatpoint.microservice.springjavaprogram.interview2.PaymentService.*(..))" , throwing = "result")
    public void afterThrowingAdvice(Exception result) {
        System.out.println("Payment Method Exception : "+result);
    }

    @Around("execution(* com.javatpoint.microservice.springjavaprogram.interview2.PaymentService.*(..))")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) {
       System.out.println("Around , Before Target Method Execution");
       Object result;
       try {
           result = joinPoint.proceed();
       } catch (Exception e) {
           throw new RuntimeException(e);
       } catch (Throwable e) {
           throw new RuntimeException(e);
       }
        System.out.println("Around , After Target Method Execution");
       return result;
    }

}
