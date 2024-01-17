package dao.util;

import entity.Customer;
import entity.Employee;
import entity.Item;
import entity.ItemCategory;
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
                .getMetadataBuilder()
                .applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
                .build();

        return metadata.getSessionFactoryBuilder()
                .build();
    }
    public static Session getSession(){

        return sessionFactory.openSession();
    }
}
