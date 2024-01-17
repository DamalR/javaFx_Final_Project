package dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ItemDto {
    private String itemId;
    private String name;
    private String fault;
    private String itemCategory;

}
