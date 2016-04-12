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

import java.util.List;

/**
 *
 * @author Takahashi
 * @param  <E> type of entity which is managed by this DAO. Reusable.
 */
public interface DataAccessObject<E>{
    
    /** Create will create a new entry, the following are the options are able 
    * to choose from. 
    */
    
    void create (E entity); 
    E read (Object id);
    List<E> readAll(); 
    void update (E Entity); 
    void delete(Object id); 
    
  
}
