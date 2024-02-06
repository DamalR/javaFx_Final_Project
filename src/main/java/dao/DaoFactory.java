package dao;

import dao.custom.impl.*;
import dao.util.DaoType;

public class DaoFactory {
    private static DaoFactory daoFactory;
    private DaoFactory(){

    }
    public static DaoFactory getInstance(){
        return daoFactory!=null? daoFactory:(daoFactory=new DaoFactory());
    }

    public <T extends SuperDao>T getDao(DaoType type){
        switch (type){
            case ITEMCATEGORY:return(T) new ItemCategoryDaoImpl();
            case EMPLOYEE:return(T) new EmployeeDaoImpl();
            case ITEM:return(T) new ItemDaoImpl();
            case CUSTOMER:return(T) new CustomerDaoImpl();
            case ORDERS:return(T) new OrdersDaoImpl();
        }
        return null;
    }
}
