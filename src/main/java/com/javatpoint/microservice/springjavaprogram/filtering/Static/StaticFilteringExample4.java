package com.javatpoint.microservice.springjavaprogram.filtering.Static;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
// Jackson serialization/deserialization (JSON ↔ Java)
public class StaticFilteringExample4 {
    public static void main(String args[]) throws IOException, ClassNotFoundException {
        UserExam user = new UserExam();
        user.setUsername("Vinod Kumar Chandani");
        user.setPassword("Kumar123@#$");
        user.setSsn("123-4412-xyz");
        user.setEmail("vinod3535chandani@gmail.com");
        // performing serialization
        // Serialization Process, using JackSon Serialization
        ObjectMapper objectMapper = new ObjectMapper();
        // serialized to JSON
        objectMapper.writeValue(new File("userExam.json"),user);
        String serializedJson = objectMapper.writeValueAsString(user);
        // print serialized JSON
        System.out.println("Serialized JSON using Jackson: "+serializedJson);
        // DeSerialization Process, using JackSon De-Serialization
        UserExam userExam2 = objectMapper.readValue(new File("userExam.json"),UserExam.class);
        System.out.println("De-Serialized JSON using Jackson: "+objectMapper.writeValueAsString(userExam2));
    }
}


@JsonIgnoreProperties(value = {"password","ssn"})
class UserExam implements Serializable {
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
