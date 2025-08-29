package com.javatpoint.microservice.springjavaprogram.Marshalling;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MarshallingExample {
    public static void main(String args[]) throws JAXBException, IOException {
        User user = new User("Vinod Kumar Chandani",29);
        // Marshalling (Java → XML) -> Using JAXB
        JAXBContext context = JAXBContext.newInstance(User.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        File file = new File("user.xml");
        marshaller.marshal(user, file);
        // marshalled data saved in user.xml file
        // converting user.xml file data to XML -> Java Object (unMarshalling)
        String content = Files.readString(Paths.get("user.xml"));
        System.out.println(content);
        System.out.println();
        Unmarshaller unmarshaller = context.createUnmarshaller();
        User user2 = (User) unmarshaller.unmarshal(file);
        System.out.println("user2 , name : "+user2.getName()+" , age : "+user2.getAge());

    }
}

@XmlRootElement
class User {
    private String name;
    private Integer age;

    public User(){

    }

    public User(String name, Integer age) {
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
