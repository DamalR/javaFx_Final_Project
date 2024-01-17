package bo.custom.impl;

import bo.custom.CustomerBo;
import bo.custom.EmployeeBo;
import dao.DaoFactory;
import dao.custom.CustomerDao;
import dao.custom.EmployeeDao;
import dao.util.DaoType;
import dto.CustomerDto;
import dto.ItemDto;
import entity.Customer;
import entity.Employee;
import entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerBoImpl implements CustomerBo {
    private CustomerDao customerDao = DaoFactory.getInstance().getDao(DaoType.CUSTOMER);
    @Override
    public boolean saveCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException {
        return customerDao.save(new Customer(
               dto.getCustomerId(),
                dto.getName(),
                dto.getContactNumber(),
                dto.getEmail(),
                dto.getAddress()
        ));
    }

    @Override
    public boolean updateCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException {
        return customerDao.update(new Customer(
                dto.getCustomerId(),
                dto.getName(),
                dto.getContactNumber(),
                dto.getEmail(),
                dto.getAddress()
        ));
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDao.delete(id);
    }

    @Override
    public List<CustomerDto> allCustomer() throws SQLException, ClassNotFoundException {
        List<Customer> entityList = customerDao.getAll();
        List<CustomerDto> list = new ArrayList<>();
        for (Customer customer : entityList) {
            list.add(new CustomerDto(
                    customer.getCustomerId(),
                    customer.getName(),
                    customer.getContactNumber(),
                    customer.getEmail(),
                    customer.getAddress()
            ));
        }
        return list;
    }
}
