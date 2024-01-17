package dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmployeeDto {
    private String empId;
    private String name;
    private String email;
    private String contactNumber;
    private String userName;
    private String password;

}
