package dao.custom;

import dao.CrudDao;
import dto.EmployeeDto;
import entity.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao extends CrudDao<Employee> {
//    List<EmployeeDto> allEmployees() throws SQLException, ClassNotFoundException;
}
