package bo.custom.impl;

import bo.custom.ItemBo;
import dao.DaoFactory;
import dao.util.DaoType;
import dto.EmployeeDto;
import dto.ItemCategoryDto;
import dto.ItemDto;
import dao.custom.ItemDao;
import entity.Item;
import entity.ItemCategory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemBoImpl implements ItemBo {
    private ItemDao itemDao = DaoFactory.getInstance().getDao(DaoType.ITEM);
    public boolean saveItem(ItemDto dto) throws SQLException, ClassNotFoundException {
        return itemDao.save(new Item(
                dto.getItemId(),
                dto.getName(),
                dto.getFault(),
                dto.getItemCategory()
        ));
    }

    @Override
    public boolean updateItem(EmployeeDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean updateItem(ItemDto dto) throws SQLException, ClassNotFoundException {
        return itemDao.update(new Item(
                dto.getItemId(),
                dto.getName(),
                dto.getFault(),
                dto.getItemCategory()
        ));
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return itemDao.delete(id);
    }

    @Override
    public List<ItemDto> allItems() throws SQLException, ClassNotFoundException {
        List<Item> entityList = itemDao.getAll();
        List<ItemDto> list = new ArrayList<>();
        for (Item item : entityList) {
            list.add(new ItemDto(
                    item.getItemId(),
                    item.getName(),
                    item.getFault(),
                    item.getItemCategory()
            ));
        }
        return list;
    }



}
