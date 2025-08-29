package com.javatpoint.microservice.springjavaprogram.filtering.Dynamic;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import java.io.Serializable;

public class DynamicFilteringExample {
    public static void main(String[] args) throws Exception {
        UserExampl user = new UserExampl();
        user.setUsername("Vinod Kumar Chandani");
        user.setPassword("Kumar123@#$");
        user.setSsn("123-4412-xyz");
        user.setEmail("vinod3535chandani@gmail.com");

        ObjectMapper mapper = new ObjectMapper();

        // Create dynamic filter — decide at runtime
        SimpleBeanPropertyFilter filter =
                SimpleBeanPropertyFilter.serializeAllExcept("password", "emailAddress");

        SimpleFilterProvider filters = new SimpleFilterProvider()
                .addFilter("userFilter", filter);

        // Serialize with the filter
        String result = mapper.writer(filters).writeValueAsString(user);

        System.out.println(result);
    }
}

@JsonFilter("userFilter")
class UserExampl implements Serializable {
    private String username;
    private String password;
    private String ssn;
    @JsonProperty("emailAddress") // Renamed the Field
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

