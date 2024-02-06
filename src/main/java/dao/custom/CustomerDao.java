package dao.custom;

import dao.CrudDao;
import dto.CustomerDto;
import dto.EmployeeDto;
import entity.Customer;
import entity.Employee;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDao extends CrudDao<Customer> {
//    List<CustomerDto> allEmployees() throws SQLException, ClassNotFoundException;
CustomerDto lastCustomer() throws SQLException, ClassNotFoundException;
}
