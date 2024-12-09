package employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
@AllArgsConstructor
@Data
public class Employee {

    private int id;
    private int age;
    private String name;
    private String department;
    private double salary;
    private Address address;
}
