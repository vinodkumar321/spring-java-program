package com.javatpoint.microservice.springjavaprogram.java8Features;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class DateTimeAPI {
    public static void main(String args[]){
        LocalDate today = LocalDate.now();
        System.out.println("Today : "+today);
        LocalDate birthday = LocalDate.of(1997, Month.AUGUST, 8);
        Period age = Period.between(birthday, today);

        System.out.println("Age Years : " + age.getYears()+" , Months : "+age.getMonths()+" , Days : "+age.getDays());

    }
}
