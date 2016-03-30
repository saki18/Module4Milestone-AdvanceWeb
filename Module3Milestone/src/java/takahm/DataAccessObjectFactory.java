/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takahm;

/**
 *
 * @author Takahashi
 */
public class DataAccessObjectFactory {
    
    //optional private constructor 
    //prevents factory objects from being created
    private DataAccessObjectFactory(){
    }
    public static DataAccessObject<User> getUserDao(){ 
        return new FileUserDao();
        
    public static DataAccessObject<Product> getProductDao(){ 
        return new FileProductDao();
        
        
    }
}
