/*
 * Masaki Takahashi
 * CITP 290 - Advance Java Programming for Business. 
 * April 12, 2016 
 * Instructor: Zach Hoffman
 * Abstract: The following program is part of a fullfiment for CITP 290, the following program 
 * will allow the user to create, edit, update, delete, and read the data product list 
 * through a web interface. 
 */
package takahm;

import edu.lcc.citp.inventory.Product;

/**
 *The class DataAccessObjectFactory, This interface represents a factory for creating an object.
 * The JNDI framework allows for object implementations to be loaded in dynamically via object factories. 
 * This will create the DataAccess object. 
 * @author Takahashi
 */
public class DataAccessObjectFactory {
    
    //optional private constructor 
    //prevents factory objects from being created
    private DataAccessObjectFactory(){
    }
    public static DataAccessObject<User> getUserDao(){ 
        return new DatabaseUserDao();
    }
    
    public static DataAccessObject<Product> getProductDao(){ 
        return new DatabaseProductDao();
        
    }
}
