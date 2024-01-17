package dto.tm;

import javafx.scene.control.Button;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmployeeTm2 {
    private String empId;
    private String name;
    private String email;
    private String contactNumber;
    private Button btn;
}
