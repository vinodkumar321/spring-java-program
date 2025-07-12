package com.javatpoint.microservice.springjavaprogram.Serialization;

import java.io.*;

public class SerializationExample  {
    public static void main(String args[]) throws IOException, ClassNotFoundException {
        Person person = new Person("Vinod Kumar Chandani",28);
        // Serialization Process
        OutputStream outputStream = new FileOutputStream("person.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(person);
        // DeSerialization Process
        InputStream inputStream = new FileInputStream("person.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        Person temp = (Person) objectInputStream.readObject();
        System.out.println("person Name : "+person.getName()+" , Age : "+person.getAge());
        System.out.println("temp Name : "+temp.getName()+" , Age : "+temp.getAge());
        if(person.equals(temp)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}

class Person implements Serializable{
    String name;
    Integer age;

    public Person(String name,Integer age){
        this.name = name;
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
