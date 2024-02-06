package dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrdersDto {
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
