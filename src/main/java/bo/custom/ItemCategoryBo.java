package bo.custom;

import bo.SuperBo;
import dto.ItemCategoryDto;
import entity.ItemCategory;

import java.sql.SQLException;
import java.util.List;

public interface ItemCategoryBo extends SuperBo {
    boolean saveItemCategory(ItemCategoryDto dto) throws SQLException, ClassNotFoundException;
    boolean updateCustomer(ItemCategoryDto dto) throws SQLException, ClassNotFoundException;
    boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;
    List<ItemCategoryDto> allItemCategory() throws SQLException, ClassNotFoundException;

}
