/*
 * Masaki Takahashi
 * CITP 290 - Advance Java Programming for Business. 
 * April 12, 2016 
 * Instructor: Zach Hoffman
 * The following program is part of a fullfiment for CITP 290, the following program 
 * will allow the user to create, edit, update, delete, and read the data product list 
 * through a web interface. 
 */
package takahm;

import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author Takahashi
 */
public class User implements Serializable {

    public static final String ADMINISTRATOR = "ADMIN";
    public static final String INVENTORY_MANAGER = "INV_MAN";

    private String username;
    private String password;
    private Set<String> roles;
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public Boolean isAdministrator() {
        return roles.contains(ADMINISTRATOR);
    }

    public Boolean isInventoryManager() {
        return roles.contains(INVENTORY_MANAGER)
                || isAdministrator();
    }
}
