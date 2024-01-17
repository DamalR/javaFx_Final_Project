package bo;

import bo.custom.impl.CustomerBoImpl;
import bo.custom.impl.EmployeeBoImpl;
import bo.custom.impl.ItemBoImpl;
import bo.custom.impl.ItemCategoryBoImpl;

import dao.util.BoType;

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

        }
        return null;
    }
}