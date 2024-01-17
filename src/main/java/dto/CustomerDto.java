package dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CustomerDto {
    private String customerId;
    private String name;
    private  String contactNumber;
    private String email;
    private String address;
}
