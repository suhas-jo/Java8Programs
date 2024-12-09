package employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Data
public class Address {
    private String street;
    private String city;
    private String state;
    private String zipCode;

}
