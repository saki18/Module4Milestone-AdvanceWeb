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

import edu.lcc.citp.utility.CollectionFileStorageUtility;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Takahashi
 */
public class FileUserDao implements DataAccessObject<User> {

    List<User> myUserList;
    
    public FileUserDao() {
        myUserList = readAll();
    }
    
    @Override
    public List<User> readAll() {
        myUserList = new ArrayList<>();

        try {
            myUserList.addAll(CollectionFileStorageUtility.load(User.class));
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: could not load user list.");
        }
        return myUserList;
    }

    @Override
    public User read(Object id) {
        String username = (String) id;
        for (User u : myUserList) {
            if (username.equalsIgnoreCase(u.getUsername())) {
                return u;
            }
        }

        return null;
    }

    @Override
    public void create(User user) {
        for (User u : myUserList) {
            if (u.getUsername().equalsIgnoreCase(user.getUsername())) {
                System.out.println("User is already in database.");
                return;
            }
        }
        myUserList.add(user);
        try {
            CollectionFileStorageUtility.save(myUserList, User.class);
        } catch (IOException e) {
            System.out.println("Error: could not save user.");
        }
    }

    @Override
    public void update(User user) {
        for (User u : myUserList) {
            if (u.getUsername().equalsIgnoreCase(user.getUsername())) {
                u.setPassword(user.getPassword());
                u.setRoles(user.getRoles());
                try {
                    CollectionFileStorageUtility.save(myUserList, User.class);
                } catch (IOException e) {
                    System.out.println("Error: could not save user.");
                }
                return;
            } else {
                System.out.println("User not found.");
            }
        }
    }

    @Override
    public void delete(Object id) {
        String username = (String) id;
        for (User u : myUserList) {
            if (u.getUsername().equalsIgnoreCase(username)) {
                myUserList.remove(u);
                System.out.println("User successfully deleted.");
                try {
                    CollectionFileStorageUtility.save(myUserList, User.class);
                } catch (IOException e) {
                    System.out.println("Error: could not delete user.");
                }
                return;
            }
        }
        System.out.println("User not found.");
    }
    
}