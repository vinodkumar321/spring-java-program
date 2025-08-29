package com.javatpoint.microservice.springjavaprogram.Marshalling;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ConversionOrTransformation {
    public static void main(String args[]) throws IOException {
        UserNew userNew = new UserNew("Vinod Kumar Chandani",29);
        // Marshalling (Java → XML) -> Using Jackson
        XmlMapper xmlMapper = new XmlMapper();
        String xmlString = xmlMapper.writeValueAsString(userNew);
        System.out.println("XML String : "+xmlString);
        System.out.println();
        JsonNode jsonNode = xmlMapper.readTree(xmlString);
        String json = new ObjectMapper().writeValueAsString(jsonNode);
        System.out.println(json);
        try {
            Files.write(
                    Paths.get("userNew.xml"),
                    xmlString.getBytes(),
                    StandardOpenOption.CREATE // Create file if it doesn't exist
            );
            System.out.println("File created and string written successfully!");
            System.out.println("Reading XML Data from File & Converting it JSON and keeping in other file");
            String xmlString2 = Files.readString(Paths.get("userNew.xml"));
            JsonNode jsonNode2 = xmlMapper.readTree(xmlString2);
            String json2 = new ObjectMapper().writeValueAsString(jsonNode);
            Files.write(
                    Paths.get("userNew.json"),
                    json2.getBytes(),
                    StandardOpenOption.CREATE // Create file if it doesn't exist
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read XML File created through MArshalling using JAXB ( Java Object to XML )
        // Read XML from file
        File file3 = new File("user.xml");

        XmlMapper xmlMapper2 = new XmlMapper();
        JsonNode node = xmlMapper.readTree(file3); // XML → JsonNode

        // Convert JsonNode to JSON String
        ObjectMapper jsonMapper = new ObjectMapper();
        String json3 = jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(node);

        System.out.println("Converted JSON thorugh JAXB XML : \n" + json3);




    }
}

@JacksonXmlRootElement
class UserNew {
    private String name;
    private Integer age;

    public UserNew(){

    }

    public UserNew(String name, Integer age) {
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
