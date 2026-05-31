package com.javatpoint.microservice.springjavaprogram.interview2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.File;

public class Marshaller {
    public static void main(String args[]) throws JAXBException, JsonProcessingException {
        Emmployee emmployee = new Emmployee(1271,"Vinod Kumar Chandani");
        /*
        JAXBContext context = JAXBContext.newInstance(Emmployee.class);
        jakarta.xml.bind.Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(jakarta.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT,true);
        marshaller.marshal(emmployee,new File("vinod.text"));
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Emmployee emmployee1 = (Emmployee) unmarshaller.unmarshal(new File("vinod.text"));
        System.out.println(emmployee1.getName()); */

        XmlMapper xmlMapper = new XmlMapper();
        String xml = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emmployee);
        System.out.println(xml);

        Emmployee empXml = xmlMapper.readValue(xml, Emmployee.class);
        System.out.println(empXml.getName());


    }
}

//@JacksonXmlRootElement(localName = "employee")
class Emmployee {
    private Integer id;
    private String name;

    public Emmployee() {

    }

    public Emmployee(Integer id, String name) {
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