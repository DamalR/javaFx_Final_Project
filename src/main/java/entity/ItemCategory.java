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
public class ItemCategory {
    @Id
    private String categoryId;
    private String categoryName;
}
