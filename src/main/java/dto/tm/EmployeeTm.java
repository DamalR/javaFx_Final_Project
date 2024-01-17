package dto.tm;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmployeeTm {
    private String empId;
    private String name;
    private String email;
    private String contactNumber;
    private String userName;
    private String password;
}
