package com.javatpoint.microservice.springjavaprogram.interview2.DesignPattern.Creational;

// Simplifies Complex Object Creation Step by Step
// Provides cleaner way to Assemble an Object.
// when class has many parameters and Object creation involves multiple steps
// when immutability is required , builder can fill fields and produce immutable objects.
// Java's String Builder , lombok Builder , HttpClient , SpringFramework Builder and Test Data Builder
public class BuilderPattern {
    public static void main(String args[]) {
        User user = new User.Builder("Vinod","Chandani")
                .setAge(29)
                .setCity("Alwar")
                .setCountry("India")
                .setEmployed(true)
                .build();
        System.out.println(user);
    }
}

class User {
    // Required Parameters
    private final String firstName;
    private final String lastName;
    // Optional Parameters
    private Integer age;
    private String city;
    private String country;
    private Boolean isEmployed;

    private User(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.city = builder.city;
        this.country = builder.country;
        this.isEmployed = builder.isEmployed;
    }

    public static class Builder {
        private final String firstName;
        private final String lastName;
        private Integer age;
        private String city;
        private String country;
        private Boolean isEmployed;

        public Builder(String firstName,String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Builder setAge(Integer age) {
            this.age = age;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setCountry(String country) {
            this.country = country;
            return this;
        }

        public Builder setEmployed(Boolean employed) {
            this.isEmployed = employed;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }


    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public Integer getAge() {
        return age;
    }


    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public Boolean getEmployed() {
        return isEmployed;
    }

    @Override
    public String toString() {
        String result = "User [ firstName "+this.firstName+" , lastName : "+this.lastName+" , Age : "+this.age
                +" , City : "+city+" , Country : "+this.country+" , isEmployed : "+this.isEmployed+" ] ";
        return result;
    }
}