package bo;

import bo.custom.impl.*;

import dao.util.BoType;

import static dao.util.DaoType.ORDERS;

public class BoFactory {
    private static BoFactory boFactory;
    private BoFactory(){

    }
    public static BoFactory getInstance(){
        return boFactory !=null? boFactory:(boFactory = new BoFactory());
    }

    public <T extends  SuperBo>T getBo(BoType type){
        switch (type){
            case ITEMCATEGORY:return (T) new ItemCategoryBoImpl();
            case EMPLOYEE:return (T) new EmployeeBoImpl();
            case ITEM:return (T) new ItemBoImpl();
            case CUSTOMER:return (T) new CustomerBoImpl();
            case ADMIN:return (T) new CustomerBoImpl();
            case ORDERS:return (T) new OrdersBoImpl();

        }
        return null;
    }
}