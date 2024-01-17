package dao.custom;

import dao.CrudDao;
import dto.ItemCategoryDto;
import entity.ItemCategory;

import java.sql.SQLException;
import java.util.List;

public interface ItemCategoryDao extends CrudDao<ItemCategory> {
    //List<ItemCategoryDto> allItemCategory() throws SQLException, ClassNotFoundException;
}
