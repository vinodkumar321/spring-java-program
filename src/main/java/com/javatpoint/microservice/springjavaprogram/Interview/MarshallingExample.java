package com.javatpoint.microservice.springjavaprogram.Interview;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.File;

public class MarshallingExample {
    public static void main(String args[]) throws JAXBException, JsonProcessingException {

        // Java -> XML -> Marshalling
        User user = new User("Vinod Kumar Chandani",29);
        JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.marshal(user,new File("user.xml"));

        // or we Have XMLMapper in place for Java -> XML ,
        // but we need to annotate class with @JacksonXmlRootElement
        UserNew userNew2 = new UserNew("Vikash Kumar Singh",38,234309.2);
        XmlMapper xmlMapper = new XmlMapper();
        String xmlString  = xmlMapper.writeValueAsString(userNew2);
        System.out.println("xmlString : "+xmlString);

        // XML -> Java -> UnMarshalling
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        User newUser = (User) unmarshaller.unmarshal(new File("user.xml"));
        System.out.println("New User , name : "+user.getName()+" , age : "+user.getAge());

        // Java -> JSON ( With Jackson Serialization )
        UserNew userNew = new UserNew("Vinod Kumar Chandani!",29,62333.5);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(userNew);
        System.out.println("json : "+json);
        // JSON -> Java ( With Jackson )
        UserNew userNew1 = objectMapper.readValue(json, UserNew.class);
        System.out.println("User New 1 , name : "+userNew1.getName()+" , age : "+userNew1.getAge()+" , salary : "+userNew1.getSalary());

        // XML -> JSON Conversion
        JsonNode jsonNode = xmlMapper.readTree(xmlString);
        String json2 = objectMapper
                .writeValueAsString(jsonNode);
        System.out.println("json2 : "+json2);

        // JSON -> XML Transformation
        JsonNode jsonNode1 = objectMapper.readTree(json2);
        String xmlUserNew = xmlMapper.writeValueAsString(jsonNode1);
        System.out.println("xmlUserNew : "+xmlUserNew);

    }
}

@JacksonXmlRootElement(localName = "userNew")
class UserNew {
    private String name;
    private Integer age;
    private  Double salary;

    public UserNew(){

    }

    public UserNew(String name, Integer age, Double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}

@XmlRootElement(name = "user")
class User {
    private String name;
    private Integer age;

    public User(){

    }

    public User(String name,Integer age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
