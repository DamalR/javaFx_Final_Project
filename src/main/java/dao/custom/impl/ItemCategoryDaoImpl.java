package dao.custom.impl;

import dao.custom.ItemCategoryDao;
import dao.util.CrudUtil;
import entity.ItemCategory;
import dao.util.HibernateUtil;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ItemCategoryDaoImpl implements ItemCategoryDao {



    @Override
    public boolean save(ItemCategory entity) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(ItemCategory entity) throws SQLException, ClassNotFoundException {
       return false;
    }

    @Override
    public boolean delete(String value) throws SQLException, ClassNotFoundException {
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(ItemCategory.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(session.find(ItemCategory.class,value));
        transaction.commit();
        return true;
    }

    @Override
    public List<ItemCategory> getAll() throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("FROM ItemCategory");
        List<ItemCategory> list1 = query.list();
//        List<ItemCategory> list = new ArrayList<>();
////
//        String sql = "SELECT * FROM itemCategory";
////        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
//        ResultSet resultSet = CrudUtil.execute(sql);
//        while (resultSet.next()){
//
//            list.add(new ItemCategory(
//                    resultSet.getString(1),
//                    resultSet.getString(2)
//            ));
//        }
        return list1;
    }


}
