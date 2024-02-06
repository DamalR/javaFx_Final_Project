package dao.custom.impl;

import dao.custom.OrdersDao;
import dao.util.HibernateUtil;
import dto.EmployeeDto;
import dto.OrdersDto;
import entity.Employee;
import entity.Orders;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class OrdersDaoImpl implements OrdersDao {
    @Override
    public boolean save(Orders entity) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Orders entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String value) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<Orders> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    public OrdersDto lastOrder() {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("FROM Orders ");
        query.setMaxResults(1);
        List<Orders> orders = query.list();

        if (!orders.isEmpty()) {
            Orders lastOrder = orders.get(0);
            return new OrdersDto(
                    lastOrder.getOrderId(),
                    lastOrder.getCustName(),
                    lastOrder.getCustContactNum(),
                    lastOrder.getItemCategoryName(),
                    lastOrder.getItemName(),
                    lastOrder.getFault(),
                    lastOrder.getDate(),
                    lastOrder.getDescription(),
                    lastOrder.getEmail(),
                    lastOrder.getStatus()
            );
        }
        return (OrdersDto) orders;

    }

}
