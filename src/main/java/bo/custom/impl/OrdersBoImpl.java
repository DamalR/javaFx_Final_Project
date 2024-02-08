package bo.custom.impl;

import bo.custom.OrdersBo;
import dao.DaoFactory;
import dao.custom.OrdersDao;
import dao.util.DaoType;
import dto.ItemCategoryDto;
import dto.OrdersDto;
import entity.ItemCategory;
import entity.Orders;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdersBoImpl implements OrdersBo {
    private OrdersDao ordersDao = DaoFactory.getInstance().getDao(DaoType.ORDERS);
    @Override
    public boolean saveOrders(OrdersDto dto) throws SQLException, ClassNotFoundException {
        return ordersDao.save(new Orders(
                dto.getOrderId(),
                dto.getCustName(),
                dto.getCustContactNum(),
                dto.getItemCategoryName(),
                dto.getItemName(),
                dto.getFault(),
                dto.getDate(),
                dto.getDescription(),
                dto.getEmail(),
                dto.getStatus()
        ));
    }

    @Override
    public boolean updateOrder(OrdersDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean deleteOrder(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<OrdersDto> allOrders() throws SQLException, ClassNotFoundException {
        List<Orders> entityList = ordersDao.getAll();
        List<OrdersDto> list = new ArrayList<>();
        for (Orders orders : entityList) {
            list.add(new OrdersDto(
                    orders.getOrderId(),
                    orders.getCustName(),
                    orders.getCustContactNum(),
                    orders.getItemCategoryName(),
                    orders.getItemName(),
                    orders.getFault(),
                    orders.getDate(),
                    orders.getDescription(),
                    orders.getEmail(),
                    orders.getStatus()
            ));
        }
        return list;
    }
}
