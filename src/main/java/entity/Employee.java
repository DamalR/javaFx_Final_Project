package entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Employee {
    @Id
    private String empId;
    private String name;
    private String email;
    private String contactNumber;
    private String userName;
    private String password;
}
