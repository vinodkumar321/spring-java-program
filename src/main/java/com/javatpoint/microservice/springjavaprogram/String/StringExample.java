package com.javatpoint.microservice.springjavaprogram.String;

/*
    This does not modify the original "Vinod" string object.
    Instead, it:
            Creates a new String object with value "Vinod Chandani".
            Assigns the new object to the reference variable str.
            The old string "Vinod" is still unchanged in memory, and if no references point to it,
            it's eligible for garbage collection.

    Analogy :
            -> "Vinod" is one String Object.
            -> " Chandani" is another.
            -> "Vinod Chandani" is new Object.

   String -> Immutable Object.
   StringBuilder -> Mutable Character Sequence. not synchronized in multi-threaded Environment.
   StringBuffer  -> Mutable Character Sequence. Ensures Thread-safety in multi-threaded Environment.
   StringTokenizer -> Allow us to Break a String into Tokens based on delimeter, not widely used.
                    -> used in textparsing, sentiment analysis. in NLP.
                    -> StringTokenizer st = new StringTokenizer(String str);
                    -> StringTokenizer st = new StringTokenizer(String str, String delimiter);
                    -> StringTokenizer st = new StringTokenizer(String str, String delimiter, boolean returnDelims);

   today we have Split() method of String class -> for more-complex tokenizatiion Method.
   because they provides much flexibility and Easy to use.
   or Scanner method for String parsing


   2. Scanner – Best for Complex Input (like user input, files, or flexible delimiters)


*/

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;
import java.util.StringTokenizer;
@RestController
@RequestMapping("string")
public class StringExample {

    @GetMapping("/public/greetMessage")
    public String greetMessageUser(){
        return "Hello Vinod Kumar, logged in as User Role,No Authentication Required";
    }

    @GetMapping("/admin/greetMessage")
    public String greetMessageAdmin(){
        return "Hello Vinod Kumar, logged in as User ADMIN,Authentication Required";
    }

    public static void main(String args[]) throws InterruptedException {
        String str = "Vinod"; // this is created in String constant pool
        String strAnotherReference = str;
        System.out.println(str);
        System.out.println(strAnotherReference);
        str += " Chandani";
        System.out.println(str);
        System.out.println(strAnotherReference);
        String newStr = new String("Vinod"); // created in heap Memory , outside the string constant pool
        // interning method , ensures even if String created with new keyword, ensures it uses String constant pool.
        String internString = new String("Vinod").intern(); // this is created in String constant pool , if
        // present , return reference otherwise create new constant in string pool and return reference of it.

        System.out.println();
        System.out.println("stringBuilder Example");
        StringBuilder stringBuilder = new StringBuilder("Vinod");
        System.out.println(stringBuilder);
        System.out.println("after appending Chandani , stringBuilder ");
        stringBuilder.append(" Chandani");
        System.out.println(stringBuilder);
        stringBuilder.append(1);
        System.out.println(stringBuilder);
        char[] s = {'H','E','L','L','O'};
        stringBuilder.append(s,2,3);
        System.out.println(stringBuilder);
        stringBuilder.append(" Namaste From GKV University",0,20);
        System.out.println(stringBuilder);
        // same methods applies to StringBuffer , string buffer is Thread safe.

        StringBuilder builder = new StringBuilder();

        // Multi-Threaded Environemnt with StringBuilder and String Buffer
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                builder.append("A");
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        // Expecting 2000 'A's but usually get less due to thread interference
        System.out.println("Length of StringBuilder : " + builder.length());
        StringBuffer buffer = new StringBuffer();
        Runnable task2 = () -> {
            for (int i = 0; i < 1000; i++) {
                buffer.append("A");
            }
        };

        Thread t3 = new Thread(task2);
        Thread t4 = new Thread(task2);

        t3.start();
        t4.start();

        t3.join();
        t4.join();

        // Expecting 2000 'A's but usually get less due to thread interference
        System.out.println("Length of StringBuffer : " + buffer.length());

        System.out.println();
        System.out.println("String Tokenizer :: Default Delimeter");
        StringTokenizer stringTokenizer = new StringTokenizer("Hello Vinod Kumar Chandani !");
        // default is whiteSpace as delimeter.
        while (stringTokenizer.hasMoreTokens()){
            System.out.println(stringTokenizer.nextToken());
        }

        StringTokenizer stringTokenizer2 = new StringTokenizer("Hello Vinod Kumar, Chandani !",",");
        // comma(,) as delimeter.
        System.out.println();
        System.out.println("String Tokenizer :: , as Delimeter whiteSpace");
        while (stringTokenizer2.hasMoreTokens()){
            System.out.println(stringTokenizer2.nextToken());
        }

        StringTokenizer stringTokenizer3 = new StringTokenizer("Hello Vinod| Kumar Chandani| !","|",true);
        // comma(|) as delimeter. and print delimeter as well.
        System.out.println();
        System.out.println("String Tokenizer :: | as Delimeter , print delimeter as well");
        while (stringTokenizer3.hasMoreTokens()){
            System.out.println(stringTokenizer3.nextToken());
        }

        System.out.println();
        System.out.println("String Split with ,");
        String sentence = "Java,Python,C++,Go";
        String[] parts = sentence.split(",");

        for (String part : parts) {
            System.out.println(part);
        }

        System.out.println();
        System.out.println("String Split with one or more spaces");
        String str4 = "Java    is  cool";
        String[] words = str4.split("\\s+"); // splits on one or more spaces
        System.out.println("words length : "+words.length);
        for(String st : words){
            System.out.println(st);
        }

        System.out.println();
        System.out.println("Using Scanner for String parsing with default whiteSpace as delimeter");
        String data = "apple banana cherry";
        Scanner scanner = new Scanner(data);

        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
        scanner.close();

        System.out.println();
        System.out.println("Using Scanner for String parsing with |  as delimeter");
        String data2 = "1|2|3|4|5|6|Vinod|7|9";
        Scanner scanner2 = new Scanner(data2);
        scanner2.useDelimiter("\\|");
        while (scanner2.hasNext()) {
            System.out.println(scanner2.next());
        }
        scanner2.close();


    }
}
