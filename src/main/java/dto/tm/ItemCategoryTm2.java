package dto.tm;

import lombok.*;

import java.awt.*;
import javafx.scene.control.Button;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class ItemCategoryTm2 extends ItemCategoryTm {
    private String categoryId;
    private String categoryName;
    private Button btn;
}