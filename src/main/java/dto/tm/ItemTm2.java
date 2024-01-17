package dto.tm;

import javafx.scene.control.Button;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ItemTm2 extends ItemCategoryTm {
    private String itemId;
    private String name;
    private String fault;
    private String itemCategory;
    private Button btn;
}
