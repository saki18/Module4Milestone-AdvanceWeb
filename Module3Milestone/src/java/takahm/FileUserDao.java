/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

    @Override
    public void create(User entity) {

        // this will create the Product List
        List<Product> pList = readAll();

        if (read(entity.getUsername()) != null) {
            System.out.println("Product already exists.");
        } else {
            pList.add();
            Collections.sort(pList);
            CollectionFileStorageUtility.save(pList, Product.class);
        }

    }

    @Override
    public User read(Object id) {
        User matchP = null;
        for (User p : readAll()) {
            if (p.getUsername().equals(id)) {
                matchP = p;
            }
        }

        return matchP;
    }

    @Override
    public List<User> readAll() {
        try {
            return new ArrayList<>(CollectionFileStorageUtility.load(User.class));
        } catch (IOException ex) {
            Logger.getLogger(FileUserDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FileUserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<>();
    }

    @Override
    public void update(User Entity) {

        List<Product> pList = readAll();

       Product matchP = null;
        for (Product pElement : pList) {
            if (pElement.getUpc().equals(p.getUpc())) {
                matchP = pElement;
            }
        }

        if (matchP == null) {
            System.out.println("Product not found.");
        } else {
            if (p.getLongDetails() != null) {
                matchP.setLongDetails(p.getLongDetails());
            }
            if (p.getPrice() != null) {
                matchP.setPrice(p.getPrice());
            }
            if (p.getShortDetails() != null) {
                matchP.setShortDetails(p.getShortDetails());
            }
            if (p.getStock() != null) {
                matchP.setStock(p.getStock());
            }

            CollectionFileStorageUtility.save(pList, Product.class);
        }

    }
    
    @Override
    public void delete(Object id) {

        List<Product> pList = readAll();

        matchP = null;
        for (Product p : pList) {
            if (p.getUpc().equals()) {
                matchP = p;
                break;
            }
        }

        if (matchP == null) {
            System.out.println("Product not found.");
        } else {
            pList.remove(matchP);
            CollectionFileStorageUtility.save(pList, Product.class);

        }
    }
}
