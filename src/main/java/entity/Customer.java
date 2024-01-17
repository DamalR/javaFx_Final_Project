package entity;

import dto.CustomerDto;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Customer {
  @Id
    private String customerId;
    private String name;
    private  String contactNumber;
    private String email;
    private String address;


}
