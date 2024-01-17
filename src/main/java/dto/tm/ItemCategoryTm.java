package dto.tm;

import lombok.*;

import java.awt.*;
import java.util.Collection;

import javafx.scene.control.Button;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class ItemCategoryTm  {
   private String categoryId;
   private String categoryName;


   public Collection<Object> getColItemCategoryId() {
      return null;
   }

   public Collection<Object> getColItemCategoryName() {
      return null;
   }
}
