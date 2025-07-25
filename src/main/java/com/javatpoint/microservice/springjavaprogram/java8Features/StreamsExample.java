package com.javatpoint.microservice.springjavaprogram.java8Features;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExample {
    public static void main(String args[]){
        List<String> names = Arrays.asList("Vinod","Aakash","Viaksh","Abhinav","Amritesh","aniket","Jatin");
        names.stream().filter(
                name -> name.startsWith("a") || name.startsWith("A") || name.startsWith("Vi")
        ).forEach(System.out::println);



        System.out.println();
        Integer[] arr = {1,2,3,4,5,6,7,8,9,0,8};
        Arrays.stream(arr).filter(n -> n%2 == 0).map(n -> n*n).sorted(Comparator.reverseOrder()).distinct().skip(2).forEach(System.out::println);

        System.out.println();
        List<Integer> list2 = Arrays.stream(arr).filter(n -> n%2 == 0).map(n -> n*n).sorted(Comparator.reverseOrder()).distinct().skip(1).toList();
        list2.forEach(System.out::println);

        System.out.println();
        // Static method - stream of , when elements are already known
        Stream<String> stream = Stream.of("Vinod","Aakash","Viaksh","Abhinav","Amritesh");
        stream.forEach(System.out::println);

        // Generator: Stream.iterate() used in infinite or pattern based stream creation
        Stream<Integer> integerStream = Stream.iterate(0,n -> n+2);
        integerStream.limit(20).forEach(System.out::println);

        // Generate Random Values
        Stream<Double> randomStream = Stream.generate(Math::random);
        randomStream.limit(3).forEach(System.out::println);

        // flatMap()
        List<List<String>> names1 = Arrays.asList(
                Arrays.asList("Vinod", "Aakash"),
                Arrays.asList("Abhinav", "Aniket")
        );

        // Using map it will print ObjectReference Hashcode not the data because it creates streams of stream, flatMap to flatten and print
        names1.stream()
                .map(Collection::stream)  // Flatten to Stream<String>
                .forEach(System.out::println);

        names1.stream()
                .flatMap(Collection::stream)  // Flatten to Stream<String>
                .forEach(System.out::println);

        // Peek() - for debugging purpose
        names.stream().filter(
                name ->  name.startsWith("Vi")
        ).peek(item -> System.out.println("Filtered : "+item)).map(String::toUpperCase)
                .peek(item -> System.out.println("Mapped : "+item)).toList();

        // Reduce ->  combine stream element and produce single result (add/product/String concatination)
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7);
        Optional<Integer> result = nums.stream().reduce(1,(a, b) -> a+b).describeConstable();
        result.ifPresent(System.out::println);

        Optional<Integer> max = nums.stream().reduce(Integer::max);
        max.ifPresent(System.out::println);
        Optional<Integer> min = nums.stream().reduce(Integer::min);
        min.ifPresent(System.out::println);
        Optional<String> concatinatedString = names.stream().reduce("",String::concat).describeConstable();
        min.ifPresent(System.out::println);


        // Grouping By
        Employee emp = new Employee("Vinod Kumar","Development",28,65234L);
        Employee emp2 = new Employee("Abhinav Yadav","Development",29,74234L);
        Employee emp3 = new Employee("Amritesh Kumar","Development",27,155234L);
        Employee emp4 = new Employee("Deepanshu Mishra","Sales",28,25234L);
        Employee emp5 = new Employee("Deepak","Research",24,75234L);
        Employee emp6 = new Employee("Nony","Research",25,85234L);

        List<Employee> employees = new ArrayList<>();
        employees.add(emp);
        employees.add(emp2);
        employees.add(emp3);
        employees.add(emp4);
        employees.add(emp5);
        employees.add(emp6);

        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .forEach((str,list) -> {
                    System.out.println("Department : "+str);
                    list.forEach(empObj -> System.out.println("Name : "+empObj.getName()
                            +", Age : "+empObj.getAge()+", Salary : "+empObj.getSalary()));
                });

        // Finding Duplicates
        List<Integer> integers = Arrays.asList(1,2,3,4,5,6,7,8,9,0,8,1,2,3,4,5);
        Optional<Integer> result2 = integers.stream().filter(i -> Collections.frequency(integers,i ) > 1)
                .distinct().max(Integer::compareTo);


        result2.ifPresent(System.out::println);


    }
}

class Employee {
    String name;
    String department;
    Integer age;
    Long Salary;

    public Employee(String name, String department, Integer age, Long salary) {
        this.name = name;
        this.department = department;
        this.age = age;
        Salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getSalary() {
        return Salary;
    }

    public void setSalary(Long salary) {
        Salary = salary;
    }
}
