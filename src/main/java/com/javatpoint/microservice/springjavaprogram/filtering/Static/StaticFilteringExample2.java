package com.javatpoint.microservice.springjavaprogram.filtering.Static;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
// java Native Serialization using ObjectOutputStream & ObjectInputStream
public class StaticFilteringExample2 {
    public static void main(String args[]) throws IOException, ClassNotFoundException {
        UserExample user = new UserExample();
        user.setUsername("Vinod Kumar Chandani");
        user.setPassword("Kumar123@#$");
        user.setSsn("123-4412-xyz");
        user.setEmail("vinod3535chandani@gmail.com");
        // password being ignored and ssn renamed to ssnNumber..
        System.out.println(new ObjectMapper().writeValueAsString(user));
        // performing serialization
        // Serialization Process
        OutputStream outputStream = new FileOutputStream("userExample.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(user);
        // DeSerialization Process
        InputStream inputStream = new FileInputStream("userExample.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        UserExample temp = (UserExample) objectInputStream.readObject();
        System.out.println(new ObjectMapper().writeValueAsString(temp));
    }
}

// Native Serialization Does not care about @JsonIgnore or @JsonIgnoreProperties, password & ssn will be still present in userExample.ser
// if you want password should not be there in serialized Object, use transient keyword for Java Native Serialization
// Question comes is if we are not using Jackson serialization , using Java Native Serialization , why password & ssn are ignored right ?
// when we do ObjectMapper().writeValueAsString(user) this line respects Jackson annotation & hide the  password & ssn , but they are present in userExample.ser
class UserExample implements Serializable {
    private String username;
    @JsonIgnore // Static filtering → Always excluded from JSON , ignored in serialization & Deserialization
    private String password;
    @JsonIgnore // Renamed in JSON
    private String ssn;
    @JsonProperty("emailAddress")
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
