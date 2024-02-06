package dao.util;

import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static SessionFactory sessionFactory = createSessionFactory();
    private static SessionFactory createSessionFactory(){
        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        Metadata metadata = new MetadataSources(standardRegistry)
                .addAnnotatedClass(ItemCategory.class)
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Item.class)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Orders.class)
                .getMetadataBuilder()
                .applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
                .build();

        return metadata.getSessionFactoryBuilder()
                .build();
    }
    public static Session getSession(){

        return sessionFactory.openSession();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory.getSessionFactory();
    }

    public static boolean validateUser(String emailId, String password) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            Employee employee = session.createQuery("FROM Employee WHERE email = :emailId AND password = :password", Employee.class)
                    .setParameter("emailId", emailId)
                    .setParameter("password", password)
                    .uniqueResult();

            session.getTransaction().commit();

            return employee != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
