package dao;

import bo.custom.impl.ItemCategoryBoImpl;
import dao.custom.impl.CustomerDaoImpl;
import dao.custom.impl.EmployeeDaoImpl;
import dao.custom.impl.ItemCategoryDaoImpl;
import dao.custom.impl.ItemDaoImpl;
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
        }
        return null;
    }
}
