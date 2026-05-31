package com.javatpoint.microservice.springjavaprogram.interview2;

import java.util.*;
import java.util.Collections;
import java.util.stream.Collectors;

public class StreamsOperationsExamples {
    public static void main(String args[]) {
        List<String> name = null;
        Optional.ofNullable(name).orElseGet(() -> Collections.emptyList())
                .stream().forEach(e -> System.out.println("Hello "+e));
        name = Arrays.asList("Vinod","Kumar","Chandani",null,"Amritesh","Abhinav","Aakash");
        Optional.ofNullable(name).orElseGet(() -> Collections.emptyList())
                .stream().filter(e -> Objects.nonNull(e)).filter(e -> e.startsWith("A")).forEach(e -> System.out.println("Hello "+e));
        Integer arr[] = {-3,-6,1,5,6,3,23,4,6,54,4,5,34543,32,-23,12,null,null};
        Arrays.stream(Optional.ofNullable(arr).orElseGet(null))
                .filter(e -> Objects.nonNull(e)).sorted(Comparator.reverseOrder()).forEach(e -> System.out.print(e+" "));
        Arrays.stream(Optional.ofNullable(arr).orElseGet(null))
                .filter(e -> Objects.nonNull(e)).sorted(Comparator.reverseOrder()).forEach(e -> System.out.print(e+" "));


        List<Employeess> empList = new ArrayList<>();
        Employeess emp1 = new Employeess(1271,"Vinod Kumar Chandani","Delivery",62333.9);
        Employeess emp2 = new Employeess(1272,"Abhinav Yadav","PMO",92333.9);
        Employeess emp3 = new Employeess(1274,"Bhavisya Manglani","PMO",42333.9);
        Employeess emp4 = new Employeess(1275,"Amritesh Kumar","Development",64333.9);
        Employeess emp5 = new Employeess(1276,"Manisha Chouhan","Delivery",65333.9);
        Employeess emp6 = new Employeess(1277,"Ritesh Agarwal","Development",66333.9);
        Employeess emp7 = new Employeess(1278,"Anjane Swami Kare","Delivery",92333.9);
        Employeess emp8 = new Employeess(1279,"Vikarabad Ahot","Delivery",62363.9);
        Employeess emp9 = new Employeess(1281,"Ajmera Hyderabada","Delivery",32333.9);
        Employeess emp10 = new Employeess(1281,"Angura Ahseef","Development",82333.9);
        empList.add(emp1);
        empList.add(emp2);
        empList.add(emp3);
        empList.add(emp4);empList.add(emp5);empList.add(emp6);empList.add(emp7);
        empList.add(emp8);empList.add(emp9);
        empList.add(emp10);
        empList.stream().
                collect(Collectors.groupingBy(Employeess::getDepartment))
                .forEach(
                        (str,list) -> {
                            System.out.println("Department : "+str);
                            for(Employeess employee : list){
                                System.out.println("Employee Name : "+employee.getEmpName()+" , Id : "+employee.getEmpId()+" , Salary : "+employee.getSalary());
                            }
                        }
                );
        empList.stream().
                collect(Collectors.toMap(
                        e -> e.getDepartment(),
                        e -> e.getEmpName() + ", id : "+ e.getEmpId() + " , salary : " + e.getSalary(),
                        (e1,e2) -> e1 + e2
                )).forEach(
                        (department,details) -> {
                            System.out.println("Department : "+department);
                            System.out.println("Details : "+details);
                        }
                );

    }
}

class Employeess {
    private Integer empId;
    private String empName;
    private String department;
    private Double salary;

    public Employeess(Integer empId, String empName, String department, Double salary) {
        this.empId = empId;
        this.empName = empName;
        this.department = department;
        this.salary = salary;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
