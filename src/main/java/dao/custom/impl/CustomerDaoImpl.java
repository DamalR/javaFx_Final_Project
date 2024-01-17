package dao.custom.impl;

import dao.custom.CustomerDao;
import dao.util.HibernateUtil;
import dto.CustomerDto;
import entity.Customer;
import entity.Employee;
import entity.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    public boolean save(Customer entity) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Customer entity) throws SQLException, ClassNotFoundException {
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
        Customer customer = session.find(Customer.class, entity.getCustomerId());
        customer.setCustomerId(entity.getCustomerId());
        customer.setName(entity.getName());
        customer.setContactNumber(entity.getContactNumber());
        customer.setEmail(entity.getEmail());
        customer.setAddress(entity.getAddress());
        session.save(customer);
        transaction.commit();

        return true;
    }

    @Override
    public boolean delete(String value) throws SQLException, ClassNotFoundException {
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(session.find(Customer.class,value));
        transaction.commit();
        return true;
    }

    @Override
    public List<Customer> getAll() throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("FROM Customer");
        List<Customer> list1 = query.list();
        return list1;
    }

}
