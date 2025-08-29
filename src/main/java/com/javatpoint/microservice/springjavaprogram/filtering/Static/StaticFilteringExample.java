package com.javatpoint.microservice.springjavaprogram.filtering.Static;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
// java Native Serialization using ObjectOutputStream & ObjectInputStream
public class StaticFilteringExample {
    public static void main(String args[]) throws IOException, ClassNotFoundException {
         User user = new User();
         user.setUsername("Vinod Kumar Chandani");
         user.setPassword("Kumar123@#$");
         user.setSsn("123-4412-xyz");
         user.setEmail("vinod3535chandani@gmail.com");
         // password being ignored and ssn renamed to ssnNumber..
         System.out.println(new ObjectMapper().writeValueAsString(user));
         // performing serialization
         // Serialization Process
         OutputStream outputStream = new FileOutputStream("user3.ser");
         ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
         objectOutputStream.writeObject(user);
         // DeSerialization Process
         InputStream inputStream = new FileInputStream("user3.ser");
         ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
         User temp = (User) objectInputStream.readObject();
        System.out.println(new ObjectMapper().writeValueAsString(temp));
    }
}

// Native Serialization Does not care about @JsonIgnore or @JsonIgnoreProperties, password will be still present in user3.ser
// if you want password should not be there in serialized Object, use transient keyword for Java Native Serialization
class User implements Serializable {
    private String username;
    private transient String password;
    @JsonProperty("ssnNumber") // Renamed in JSON
    private String ssn;
    @JsonIgnore
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
