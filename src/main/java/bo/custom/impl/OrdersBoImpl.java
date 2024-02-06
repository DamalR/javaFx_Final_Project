package bo.custom.impl;

import bo.custom.OrdersBo;
import dao.DaoFactory;
import dao.custom.OrdersDao;
import dao.util.DaoType;
import dto.OrdersDto;
import entity.Orders;

import java.sql.SQLException;
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
        return null;
    }
}
