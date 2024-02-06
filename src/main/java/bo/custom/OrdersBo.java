package bo.custom;

import bo.SuperBo;
import dto.OrdersDto;

import java.sql.SQLException;
import java.util.List;

public interface OrdersBo extends SuperBo {
    boolean saveOrders(OrdersDto dto) throws SQLException, ClassNotFoundException;
    boolean updateOrder(OrdersDto dto) throws SQLException, ClassNotFoundException;
    boolean deleteOrder(String id) throws SQLException, ClassNotFoundException;
    List<OrdersDto> allOrders() throws SQLException, ClassNotFoundException;
}
