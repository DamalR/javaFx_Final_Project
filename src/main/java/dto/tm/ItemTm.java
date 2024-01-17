package dto.tm;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ItemTm {


    private String itemId;
    private String name;
    private String fault;
    private String itemCategory;


}
