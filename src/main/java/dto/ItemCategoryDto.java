package dto;

import dto.tm.ItemCategoryTm;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter

public class ItemCategoryDto {
    private String categoryId;
    private String categoryName;
}
