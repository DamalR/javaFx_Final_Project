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
public class Orders {
    @Id
    private String orderId;
    private String custName;
    private String custContactNum;
    private String itemCategoryName;
    private String itemName;
    private String fault;
    private String date;
    private String description;
    private String email;
    private String status;


}
