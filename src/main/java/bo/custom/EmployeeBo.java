package bo.custom;

import bo.SuperBo;
import dto.EmployeeDto;
import dto.ItemCategoryDto;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeBo extends SuperBo {
    boolean saveEmployee(EmployeeDto dto) throws SQLException, ClassNotFoundException;
    boolean updateCustomer(EmployeeDto dto) throws SQLException, ClassNotFoundException;
    boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;
    List<EmployeeDto> allEmployees() throws SQLException, ClassNotFoundException;
}
