package streams;

import employee.Employee;
import employee.EmployeeDb;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeProblems {

    public static void main(String[] args) {
       
        List<Employee> employeeList = EmployeeDb.getEmployees();
        
//        filterBasedOnDept(employeeList);

//        createListOfEmployeeNames(employeeList);

//        sortEmployeesByName(employeeList);
//        sortEmployeeByAge(employeeList);
//        calculateAvgAge(employeeList);
//        findMaxAge(employeeList);
        findMaxAgeEmployee(employeeList);
//        groupEmployeesByDept(employeeList);

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
