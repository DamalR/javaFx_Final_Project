package bo.custom.impl;

import bo.custom.EmployeeBo;
import dao.CrudDao;
import dao.DaoFactory;
import dao.custom.EmployeeDao;
import dao.util.DaoType;
import dto.EmployeeDto;
import dto.ItemCategoryDto;
import dto.ItemDto;
import entity.Employee;
import entity.Item;
import entity.ItemCategory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeBoImpl implements EmployeeBo {
    private EmployeeDao employeeDao = DaoFactory.getInstance().getDao(DaoType.EMPLOYEE);

    @Override
    public boolean saveEmployee(EmployeeDto dto) throws SQLException, ClassNotFoundException {
        return employeeDao.save(new Employee(
                dto.getEmpId(),
                dto.getName(),
                dto.getEmail(),
                dto.getContactNumber(),
                dto.getUserName(),
                dto.getPassword()
        ));
    }

    @Override
    public boolean updateCustomer(EmployeeDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return employeeDao.delete(id);
    }

    @Override
    public List<EmployeeDto> allEmployees() throws SQLException, ClassNotFoundException {
        List<Employee> entityList = employeeDao.getAll();
        List<EmployeeDto> list = new ArrayList<>();
        for (Employee employee : entityList) {
            list.add(new EmployeeDto(
                    employee.getEmpId(),
                    employee.getName(),
                    employee.getContactNumber(),
                    employee.getEmail(),
                    employee.getUserName(),
                    employee.getPassword()
            ));
        }
        return list;
    }


}
