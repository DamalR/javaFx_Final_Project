package dao.custom;

import dao.CrudDao;
import dto.EmployeeDto;
import dto.OrdersDto;
import entity.Orders;

import java.sql.SQLException;

public interface OrdersDao extends CrudDao<Orders> {
//        List<OrderDto> allOrders() throws SQLException, ClassNotFoundException;
OrdersDto lastOrder() throws SQLException, ClassNotFoundException;
}
