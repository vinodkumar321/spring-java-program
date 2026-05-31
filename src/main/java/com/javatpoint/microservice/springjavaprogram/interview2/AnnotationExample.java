package com.javatpoint.microservice.springjavaprogram.interview2;

import java.lang.annotation.*;

public class AnnotationExample {
    public static void main(String args[]) throws Exception {
        Class<?> clazz = Test.class;
        MyAnnotation classLevel = Test.class.getAnnotation(MyAnnotation.class);
        System.out.println("class Level Annotation Value : "+ classLevel.value());
        MyAnnotation enumLevel = Name.class.getAnnotation(MyAnnotation.class);
        System.out.println("Enum Level Annotation Value : "+ enumLevel.value());
        MyAnnotation interfaceLevel = myInterface.class.getAnnotation(MyAnnotation.class);
        System.out.println("Interface Level Annotation Value : "+ interfaceLevel.value());

        Annotation[] annotations = RepeatingExample.class.getAnnotations();
        for(Annotation annotation : annotations){
            System.out.println(annotation);
        }
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)
@Repeatable(Hints.class)
@interface Hint {
   String value();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)
@interface Hints {
    Hint[] value();
}

@Hint("First Hint")
@Hint("Second Hint")
class RepeatingExample {

}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface MyAnnotation {
    String value();
}

@MyAnnotation("Vinod")
class Test {

}

@MyAnnotation("Kumar")
enum Name {

}

@MyAnnotation("Chandani")
interface myInterface {

}