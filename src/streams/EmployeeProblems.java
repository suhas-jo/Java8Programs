package streams;

import employee.Employee;
import employee.EmployeeDb;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeProblems {

    public static void main(String[] args) {
       
        List<Employee> employeeList = EmployeeDb.getEmployees();
        
//        filterBasedOnDept(employeeList);

        createListOfEmployeeNames(employeeList);

//        sortEmployeesByName(employeeList);
//        sortEmployeeByAge(employeeList);
//        calculateAvgAge(employeeList);
//        findMaxAge(employeeList);
//        findMaxAgeEmployee(employeeList);
//        groupEmployeesByDept(employeeList);
//        sumEployeeAge(employeeList);
//        createCommaSeperatedEmployees(employeeList);
//        findEmployeeWithMinSalary(employeeList);
//        removeEmployeeWithSalaryLessThan50k(employeeList);
//        replaceEmployeeNameWhoseSalLessThan50K(employeeList);
        divideEmployeeBasedOnOddAndEvenAge(employeeList);
}

    private static void divideEmployeeBasedOnOddAndEvenAge(List<Employee> employeeList) {

        Map<Boolean,List<Employee>> employeeGroup = employeeList.stream()
                .collect(Collectors.partitioningBy(employee -> employee.getAge()%2==0));
        employeeGroup.get(true).forEach(employee -> System.out.println(employee.getName() + "'s age is " + employee.getAge()));
        employeeGroup.get(false).forEach(employee -> System.out.println(employee.getName() + "'s age is " + employee.getAge()));
    }

    private static void replaceEmployeeNameWhoseSalLessThan50K(List<Employee> employeeList) {

        employeeList.replaceAll(employee -> employee.getSalary()<50000?new Employee(employee.getId(),employee.getAge(),"AAA",employee.getDepartment(),
                employee.getSalary(),employee.getAddress()):employee);

        employeeList.forEach(employee -> System.out.println(employee.getName() + " is getting salary " + employee.getSalary()) );
    }

    private static void removeEmployeeWithSalaryLessThan50k(List<Employee> employeeList) {
        employeeList.removeIf(employee -> employee.getSalary()<50000);
        employeeList.forEach(employee -> System.out.println(employee.getName() + " getting salary : " + employee.getSalary()));

        //sort based on based Salary
        System.out.println("*****Sorted employee based on Salary***********");
        employeeList.stream().sorted(Comparator.comparing(Employee::getSalary))
                .forEach(employee -> System.out.println(employee.getName() + " getting salary " + employee.getSalary()));
    }

    private static void findEmployeeWithMinSalary(List<Employee> employeeList) {

       Optional<Employee> minSalEmployee = employeeList.stream().min(Comparator.comparing(Employee::getSalary));

        minSalEmployee.ifPresent(System.out::println);
    }

    private static void createCommaSeperatedEmployees(List<Employee> employeeList) {
        String names = employeeList.stream().map(Employee::getName).collect(Collectors.joining(","));
        System.out.println(names);
    }

    private static void sumEployeeAge(List<Employee> employeeList) {

        IntSummaryStatistics intSummaryStatistics = employeeList.stream().mapToInt(Employee::getAge).summaryStatistics();

        System.out.println(intSummaryStatistics.getSum());
        System.out.println(intSummaryStatistics.getMin());
        System.out.println(intSummaryStatistics.getMax());
        System.out.println(intSummaryStatistics.getAverage());
    }


    private static void groupEmployeesByDept(List<Employee> employeeList) {

        employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment))
                .forEach((key, value) -> System.out.println(key + " ---> " + value));
    }

    private static void findMaxAgeEmployee(List<Employee> employeeList) {

        Optional<Employee> maxAgeEmployee = employeeList.stream().max(Comparator.comparing(Employee::getAge));

        maxAgeEmployee.ifPresent(System.out::println);
    }

    private static void findMaxAge(List<Employee> employeeList) {
        int maxAge = employeeList.stream().mapToInt(Employee::getAge).max().orElse(0);
        System.out.println(maxAge);
    }

    private static void calculateAvgAge(List<Employee> employeeList) {

        double avgAge = employeeList.stream().mapToDouble(Employee::getAge).average().orElse(0.0);
        System.out.println(avgAge);
    }

    private static void sortEmployeeByAge(List<Employee> employeeList) {

        employeeList.stream().sorted(Comparator.comparing(Employee::getAge)).forEach(System.out::println);
    }

    private static void sortEmployeesByName(List<Employee> employeeList) {

        employeeList.stream().sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println);
    }

    private static void createListOfEmployeeNames(List<Employee> employeeList) {

        List<String> list = employeeList.stream().map(Employee::getName).toList();
        System.out.println(list);
    }

    private static void filterBasedOnDept(List<Employee> employeeList) {

        employeeList.stream()
                .filter(employee -> employee.getDepartment().startsWith("E"))
                .forEach(System.out::println);
    }
}
