package com.javatpoint.microservice.springjavaprogram.interview2;

import java.util.*;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsExample {
    public static void main(String args[]){
        Collection<String> list = new ArrayList<>();
        list.add("Vinod");
        list.add("Vijay");
        list.add("Vikram");
        list.add("Vinod");
        list.add("Vijay");
        list.add("Vinni");
        list.add("Vikash");
        list.add("Aakash");
        list.add("Akshat");
        list.add("Amritesh");
        list.add("Jampa");
        list.add("Uganda");
        list.add(null);
        list.add(null);
        // Collector.goupingBy works
        Collection<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Vinod","Sales"));
        employeeList.add(new Employee("Vikash","Marketing"));
        employeeList.add(new Employee("Vishal","Marketing"));
        employeeList.add(new Employee("Aakash","Marketing"));
        employeeList.add(new Employee("Neeraj","Delivery"));
        employeeList.add(new Employee("NemiChand","Delivery"));
        employeeList.add(new Employee("Sunil","Development"));
        employeeList.add(new Employee("Abhinav","Development"));
        Map<String,List<Employee>> departmentWiseGrouping = employeeList.stream().filter(Objects::nonNull).collect(Collectors.groupingBy(Employee::getDeparment));
        for(Map.Entry<String,List<Employee>> entry : departmentWiseGrouping.entrySet()) {
            System.out.println("Department : "+entry.getKey());
            for(Employee employee : entry.getValue()){
                System.out.println(employee.getName());
            }
            System.out.println();
        }
        Map<String, List<String>> departmentWiseGroupingwithName = employeeList.stream().filter(Objects::nonNull).collect(Collectors.groupingBy(Employee::getDeparment
                , Collectors.mapping(Employee::getName,Collectors.toList())
        ));

        System.out.println(departmentWiseGroupingwithName);

        Map<String, String> nameWiseGrouping = employeeList.stream().filter(Objects::nonNull).collect(
                Collectors.toMap(Employee::getDeparment
                        ,Employee::getName
                        , (name1,name2) -> name1 + " + " + name2
                ));

        System.out.println(nameWiseGrouping);
        // second highest using stream API
        Collection<Integer> integerList = List.of(1,2,3,4,5,6,7,8,9,10);
        // find minimum and maximum
        Optional<Integer> min = integerList.stream().reduce((a,b) -> Integer.min(a,b));
        Optional<Integer> max = integerList.stream().reduce((a,b) -> Integer.max(a,b));
        min.ifPresent(e -> System.out.println("min : "+e));
        max.ifPresent(e -> System.out.println("max : "+e));
        Optional<Integer> second_highestSalary = integerList.stream().filter(Objects::nonNull).distinct().sorted(Comparator.reverseOrder()).limit(2).skip(1).findFirst();
        second_highestSalary.ifPresent(System.out::println);
        // want any element greater than 2 - short circuiting example
        Integer result = integerList.stream().filter(Objects::nonNull).filter(
                x -> x > 2).findFirst().orElseGet(() -> null);
        System.out.println("result : "+result);
        // remove duplicates
        List<String> removeDuplicates = Optional.ofNullable(list).orElseGet(java.util.Collections::emptyList)
                .stream().filter(Objects::nonNull).distinct().collect(Collectors.toList());
        System.out.println("remove duplicates : " + removeDuplicates);
        // upper case
        List<String> upperCase = Optional.ofNullable(list).orElseGet(java.util.Collections::emptyList)
                .stream().filter(x -> x != null).map(x -> x.toUpperCase()).collect(Collectors.toList());
        System.out.println("upper case : "+upperCase);
        // null-safe way
        List<String> processed = Optional.ofNullable(list).orElseGet(Collections::emptyList)
                .stream().filter(x -> x != null).collect(Collectors.toList());
        System.out.println(list);

        System.out.println("Processed : "+processed);
        int[] arr = {1, 2, 3};
        IntStream stream = Arrays.stream(arr);

        // System.out.println(stream.count()); // Output: 3
        stream.forEach(System.out::println);

        System.out.println();

        // used in infinite or pattern based Stream Generation
        Stream<Integer> integers = Stream.iterate(0,n -> n+2);
                integers.limit(14).forEach(System.out::println);

        Stream<Double> random = Stream.generate(() -> Math.random()).limit(10);
        random.forEach(System.out::println);

        // flat-map
        List<List<String>> nameList = Arrays.asList(
                Arrays.asList("Vinod","Kumar","Chandani"),
                Arrays.asList("Priyanshi","Kumari","BulChandani"),
                Arrays.asList("Harsha","Kumari","Chandani")
        );

        nameList.stream();

    }
}

class Employee {
    private String name;
    private String deparment;

    public Employee(String name,String deparment){
        this.name = name;
        this.deparment = deparment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeparment() {
        return deparment;
    }

    public void setDeparment(String deparment) {
        this.deparment = deparment;
    }
}
