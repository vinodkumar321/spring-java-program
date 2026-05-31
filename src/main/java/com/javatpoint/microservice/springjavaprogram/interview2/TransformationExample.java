package com.javatpoint.microservice.springjavaprogram.interview2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

public class TransformationExample {
    public static void main(String args[]) throws JsonProcessingException {
        Emmployees emp = new Emmployees(1271,"Vinod Kumar Chandani");
        XmlMapper xmlMapper = new XmlMapper();
        String xml = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
        System.out.println(xml);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = xmlMapper.readTree(xml);
        String json = objectMapper.writeValueAsString(jsonNode);
        System.out.println("json : "+json);
        jsonNode = objectMapper.readTree(json);
        String xml2 = xmlMapper.writeValueAsString(jsonNode);
        System.out.println("xml2 : "+xml2);

        Emmployees emp2 = (Emmployees) objectMapper.readValue(json, Emmployees.class);
        String xml3 = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp2);
        System.out.println("xml3 : "+xml3);

    }
}

class Emmployees {
    private Integer id;
    private String name;

    public Emmployees() {

    }

    public Emmployees(Integer id, String name) {
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

