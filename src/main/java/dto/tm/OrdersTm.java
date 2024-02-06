package dto.tm;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrdersTm {
    private String orderId;
    private String custName;
    private String itemCategoryName;
    private String itemName;
    private String fault;
}
