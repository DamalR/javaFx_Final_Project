package dao.custom;

import dao.CrudDao;
import dto.EmployeeDto;
import dto.ItemCategoryDto;
import entity.ItemCategory;

import java.sql.SQLException;
import java.util.List;

public interface ItemCategoryDao extends CrudDao<ItemCategory> {
    //List<ItemCategoryDto> allItemCategory() throws SQLException, ClassNotFoundException;
    ItemCategoryDto lastItemCategory() throws SQLException, ClassNotFoundException;
}
