package dao.custom.impl;

import dao.custom.EmployeeDao;
import dao.util.HibernateUtil;
import db.DBConnection;
import dto.EmployeeDto;
import entity.Employee;
import entity.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public boolean save(Employee entity) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Employee entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String value) throws SQLException, ClassNotFoundException {
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(session.find(Employee.class,value));
        transaction.commit();
        return true;
    }

    @Override
    public List<Employee> getAll() throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("FROM Employee ");
        List<Employee> list1 = query.list();
        return list1;
    }

    public EmployeeDto lastEmployee() {
//        String hql = "FROM Employee e ORDER BY e.empId DESC";

        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("FROM Employee ");
        query.setMaxResults(1);
        List<Employee> employees = query.list();

        if (!employees.isEmpty()) {
            Employee lastEmployee = employees.get(0);
            return new EmployeeDto(
                    lastEmployee.getEmpId(),
                    lastEmployee.getName(),
                    lastEmployee.getEmail(),
                    lastEmployee.getContactNumber(),
                    lastEmployee.getPassword()
            );
        }
        return (EmployeeDto) employees;

    }



}
