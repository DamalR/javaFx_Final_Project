package dto.tm;

import lombok.*;

import javafx.scene.control.Button;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CustomerTm {
    private String customerId;
    private String name;
    private  String contactNumber;
    private String email;
    private String address;
    private Button btn;
}
