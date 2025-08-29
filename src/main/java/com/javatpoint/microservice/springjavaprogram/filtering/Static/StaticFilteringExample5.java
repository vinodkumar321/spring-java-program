package com.javatpoint.microservice.springjavaprogram.filtering.Static;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
// Jackson serialization/deserialization (JSON ↔ Java)
public class StaticFilteringExample5 {

    public static void main(String args[]) throws IOException, ClassNotFoundException {
        UserExamp user = new UserExamp();
        user.setUsername("Vinod Kumar Chandani");
        user.setPassword("Kumar123@#$");
        user.setSsn("123-4412-xyz");
        user.setEmail("vinod3535chandani@gmail.com");
        // performing serialization
        // Serialization Process, using JackSon Serialization
        ObjectMapper objectMapper = new ObjectMapper();
        // serialized to JSON
        objectMapper.writeValue(new File("userExamp.json"),user);
        String serializedJson = objectMapper.writeValueAsString(user);
        // print serialized JSON
        System.out.println("Serialized JSON using Jackson: "+serializedJson);
        // DeSerialization Process, using JackSon De-Serialization
        UserExamp userExamp2 = objectMapper.readValue(new File("userExamp.json"),UserExamp.class);
        System.out.println("De-Serialized JSON using Jackson: "+objectMapper.writeValueAsString(userExamp2));
    }
}

// allowGetters = true → field will still be readable in JSON output but will be ignored during deserialization.
@JsonIgnoreProperties(value = {"password","ssn"}, allowGetters = true)
class UserExamp implements Serializable {
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



