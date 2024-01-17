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
public class Item {
    @Id
    private String itemId;
    private String name;
    private String fault;
    private String itemCategory;
}
