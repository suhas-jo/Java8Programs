package employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDb {

    public static void main(String[] args) {
        getEmployees();
    }

    public static List<Employee> getEmployees() {
        Address address1 = new Address("123 Main St", "Springfield", "IL", "62701");
        Employee employee1 = new Employee(101,20, "Alice", "Engineering",25000, address1);
        Address address2 = new Address("54 Main St", "Springfield", "IL", "62702");
        Employee employee2 = new Employee(102,22, "Bob", "HR",35000, address2);
        Address address7 = new Address("5 Main St", "Springfield", "IL", "62708");
        Employee employee7 = new Employee(107,35, "George", "DEV-OPS",22000, address7);

        Address address8 = new Address("4 Main St", "Springfield", "IL", "62709");
        Employee employee8 = new Employee(108,30, "Hannah", "Engineering",45000, address8);

        Address address9 = new Address("5 Main St", "Springfield", "IL", "62708");
        Employee employee9 = new Employee(109,31, "Ivan", "DEV-OPS",55000, address9);

        Address address3 = new Address("43 Main St", "Springfield", "IL", "62703");
        Employee employee3 = new Employee(103,24, "Charlie", "QA",83000, address3);

        Address address4 = new Address("9 Main St", "Springfield", "IL", "62705");
        Employee employee4 = new Employee(104,28, "Diana", "Engineering",34000, address4);

        Address address5 = new Address("8 Main St", "Springfield", "IL", "62706");
        Employee employee5 = new Employee(105,56, "Edward", "HR",546000, address5);

        Address address6 = new Address("7 Main St", "Springfield", "IL", "62707");
        Employee employee6 = new Employee(106,34, "Fiona", "QA",85000, address6);



        Address address10 = new Address("4 Main St", "Springfield", "IL", "62709");
        Employee employee10 = new Employee(110,29, "Julia", "QA",25000, address10);

        List<Employee> employeesList = new ArrayList<>();
        employeesList.add(employee7);
        employeesList.add(employee8);
        employeesList.add(employee9);
        employeesList.add(employee1);
        employeesList.add(employee2);
        employeesList.add(employee3);
        employeesList.add(employee4);
        employeesList.add(employee5);
        employeesList.add(employee6);

        employeesList.add(employee10);

        return  employeesList;

    }


}
