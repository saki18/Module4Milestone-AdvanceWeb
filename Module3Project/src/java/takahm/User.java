/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
