package com.javatpoint.microservice.springjavaprogram.sampleProgram;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EvenNumberProgram {
    public static void main(String args[]){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> result = numbers.stream().filter(n -> n%2 == 0).collect(Collectors.toList());
        System.out.println(result);
        List<String> names = Arrays.asList("Alice", "Bob", "Ankit", "David");
        List<String> result2 = names.stream().filter(n -> n.startsWith("A")).collect(Collectors.toList());
        System.out.println(result2);
        List<String> fruits = Arrays.asList("apple", "banana", "mango");
        List<String> result3 = fruits.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(result3);
        List<String> words = Arrays.asList("stream", "lambda", "api", "function");
        Long result4 = words.stream().filter(e -> e.length() > 5).count();
        System.out.println(result4);
        // Find Duplicate Element in a given List
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 2, 4, 5, 1, 6);
        System.out.println(numbers2);
        List<Integer> result5 = numbers2.stream().filter(i -> Collections.frequency(numbers2,i) > 1).distinct().toList();
        System.out.println(result5);
        String input = "swiss";
        // Find First non-repeated character in a string
        List<Character> list = input.chars().mapToObj(c -> (char)c).collect(Collectors.toList());
        List<Character> finalList = list;
        Optional<Character> ch = list.stream().filter(c -> Collections.frequency(finalList,c) == 1).skip(1).findFirst();
        ch.ifPresent(System.out::println);
        // Find Second Highest number in a list
        List<Integer> numbers3 = Arrays.asList(10, 20, 30, 40, 50);
        Optional<Integer> result6 = numbers3.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst();
        result6.ifPresent(System.out::println);
        // sort list of Employee by Salary ascending/descending
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 5000),
            new Employee("Bob", 7000),
            new Employee("Charlie", 6000)
        );
        Comparator<Employee> employeeComparator = Comparator.comparingInt(e -> e.getSalary());
        List<Employee> empList = employees.stream().sorted(employeeComparator).collect(Collectors.toList());
        System.out.println("Sorted by Salary Ascending order");
        for(Employee e : empList)
            System.out.println("Name : "+e.getName()+" , Salary : "+e.getSalary());
        employeeComparator = employeeComparator.reversed();
        List<Employee> empList2 = employees.stream().sorted(employeeComparator).collect(Collectors.toList());
        System.out.println("Sorted by Salary Descending order");
        for(Employee e : empList2)
            System.out.println("Name : "+e.getName()+" , Salary : "+e.getSalary());
        // Advance Level -> Group by words by their lengths
        List<String> words2 = Arrays.asList("java", "stream", "api", "lambda", "code","code");
        Map<Integer,List<String>> result7 = words2.stream().collect(Collectors.groupingBy(String::length));
        System.out.println("result7 : "+result7);
        // Advance Level -> Group by words by their lengths and word count
        Map<Integer,Long> result8 = words2.stream().collect(Collectors.groupingBy(String::length,Collectors.counting()));
        System.out.println("result8 : "+result8);
        // Advance Level -> Group into Set By Length
        Map<Integer,Set<String>> result9 = words2.stream().collect(Collectors.groupingBy(String::length,Collectors.toSet()));
        System.out.println("result9 : "+result9);
        // Find the frequency of each character in a string
        input = "banana";
        list = input.chars().mapToObj(c -> (char)c).toList();
        Map<Character,Long> map = list.stream().collect(Collectors.groupingBy(Character::charValue,Collectors.counting()));
        System.out.println("map : "+map);
        // Find the longest word in a list
        List<String> wordss = Arrays.asList("java", "stream", "function", "lambdakk");
        Optional<String> result10 = wordss.stream().max(Comparator.comparingInt(e -> e.length()));
        result10.ifPresent(System.out::println);
        System.out.println("if multiple are there skip first with max length");
        int maxLength = wordss.stream().mapToInt(String::length).max().orElse(0);
        List<String> maxLengths = wordss.stream().filter(e -> e.length() == maxLength).toList();
        Optional<String> str = maxLengths.size() > 1 ? maxLengths.get(1).describeConstable() : (maxLengths.isEmpty() ? null : maxLengths.get(0).describeConstable());
        str.ifPresent(System.out::println);
        // Partition numbers into even and odd
        List<Integer> numbersw = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Map<Boolean,List<Integer>> map2 = numbersw.stream().collect(Collectors.partitioningBy(n->n%2 !=0));
        System.out.println("map2 : "+map2);
    }
}

class Employee {
    String name;
    int salary;
    Employee(String name, int salary) {
        this.name = name; this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
