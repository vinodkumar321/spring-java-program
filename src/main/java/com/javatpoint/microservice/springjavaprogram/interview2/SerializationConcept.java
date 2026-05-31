package com.javatpoint.microservice.springjavaprogram.interview2;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class SerializationConcept {
    public static void main(String args[]) throws IOException, ClassNotFoundException {
        // basic serilization - converts Java Object to ByteStream
        // Java Native Serialization

        Emmploye emp1 = new Emmploye(1271,"Vinod Kumar Chandani");
        /*
        OutputStream os = new FileOutputStream("vinod_new.txt");
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(emp1);

        // Java Native Deserialization
        InputStream ip = new FileInputStream("vinod_new.txt");
        ObjectInputStream ois = new ObjectInputStream(ip);
        Emmploye emp2 = (Emmploye) ois.readObject();
        System.out.println(emp2.getId());
        System.out.println(emp2.getName());
        */
        // JackSon Serialization
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(emp1);
        System.out.println("json : "+json);
        // Jackson De-Serialization
        Emmploye emp3 = (Emmploye) objectMapper.readValue(json, Emmploye.class);
        System.out.println(emp3.getName());
        System.out.println(emp3.getId());

    }
}

class Emmploye {
    private Integer id;
    private String name;

    public Emmploye() {

    }

    public Emmploye(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
