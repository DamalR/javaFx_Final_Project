package dao.custom.impl;

import dao.custom.ItemDao;
import dao.util.HibernateUtil;
import dto.EmployeeDto;
import dto.ItemDto;
import entity.Employee;
import entity.Item;
import entity.ItemCategory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class ItemDaoImpl implements ItemDao {
    @Override
    public boolean save(Item entity) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Item entity) throws SQLException, ClassNotFoundException {
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Item.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
        Item item = session.find(Item.class, entity.getItemId());
        item.setItemId(entity.getItemId());
        item.setName(entity.getName());
        item.setFault(entity.getFault());
        item.setItemCategory(entity.getItemCategory());
        session.save(item);
        transaction.commit();

        return true;
    }

    @Override
    public boolean delete(String value) throws SQLException, ClassNotFoundException {
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Item.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(session.find(Item.class,value));
        transaction.commit();
        return true;
    }

    @Override
    public List<Item> getAll() throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("FROM Item ");
        List<Item> list1 = query.list();
        return list1;
    }

    public ItemDto lastItem() {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("FROM Item");
        query.setMaxResults(1);
        List<Item> item = query.list();

        if (!item.isEmpty()) {
            Item lastItem = item.get(0);
            return new ItemDto(
                    lastItem.getItemId(),
                    lastItem.getName(),
                    lastItem.getFault(),
                    lastItem.getItemCategory()
            );
        }
        return (ItemDto) item;

    }



}
