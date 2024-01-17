package bo.custom.impl;

import bo.custom.ItemCategoryBo;
import dao.DaoFactory;
import dao.custom.ItemCategoryDao;
import dao.util.DaoType;
import dto.ItemCategoryDto;
import entity.ItemCategory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemCategoryBoImpl implements ItemCategoryBo {
    private ItemCategoryDao itemCategoryDao = DaoFactory.getInstance().getDao(DaoType.ITEMCATEGORY);
    @Override
    public boolean saveItemCategory(ItemCategoryDto dto) throws SQLException, ClassNotFoundException {
        return itemCategoryDao.save(new ItemCategory(
                dto.getCategoryId(),
                dto.getCategoryName()

        ));
    }


    @Override
    public boolean updateCustomer(ItemCategoryDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return itemCategoryDao.delete(id);
    }

    @Override
    public List<ItemCategoryDto> allItemCategory() throws SQLException, ClassNotFoundException {
        List<ItemCategory> entityList = itemCategoryDao.getAll();
        List<ItemCategoryDto> list = new ArrayList<>();
        for (ItemCategory itemCategory : entityList) {
            list.add(new ItemCategoryDto(
                    itemCategory.getCategoryId(),
                    itemCategory.getCategoryName()
            ));
        }
        return list;
    }

}
