/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takahm;

import edu.lcc.citp.inventory.Product;
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
public class FileProductDao implements DataAccessObject<Product> {

    List<Product> myProductList;
    
    public FileProductDao() {
        myProductList = readAll();
    }
    
    @Override
    public List<Product> readAll() {
        myProductList = new ArrayList<>();

        try {
            myProductList.addAll(CollectionFileStorageUtility.load(Product.class));
        } catch (IOException ex) {
            Logger.getLogger(FileProductDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FileProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return myProductList;
    }

    @Override
    public Product read(Object id) {
        String upc = (String) id;
        for (Product p : myProductList) {
            if (upc.equalsIgnoreCase(p.getUpc())) {
                return p;
            }
        }

        return null;
    }

    @Override
    public void create(Product p) {
        for (Product product : myProductList) {
            if (product.compareTo(p) == 0) {
                System.out.println("Product is already in database.");
                return;
            }
        }
        myProductList.add(p);
        try {
            CollectionFileStorageUtility.save(myProductList, Product.class);
        } catch (IOException ex) {
            Logger.getLogger(FileProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Product p) {
        for (Product product : myProductList) {
            if (product.compareTo(p) == 0) {
                product.setShortDetails(p.getShortDetails());
                product.setLongDetails(p.getLongDetails());
                product.setPrice(p.getPrice());
                product.setStock(p.getStock());
                try {
                    CollectionFileStorageUtility.save(myProductList, Product.class);
                } catch (IOException ex) {
                    Logger.getLogger(FileProductDao.class.getName()).log(Level.SEVERE, null, ex);
                }
                return;
            } else {
                System.out.println("Product not found.");
            }
        }
    }

    @Override
    public void delete(Object id) {
        
        String upc = (String) id;
        for (Product p : myProductList) {
            if (p.getUpc().equalsIgnoreCase(upc)) {
                myProductList.remove(p);
                System.out.println("Product successfully deleted.");
                try {
                    CollectionFileStorageUtility.save(myProductList, Product.class);
                } catch (IOException ex) {
                    Logger.getLogger(FileProductDao.class.getName()).log(Level.SEVERE, null, ex);
                }
                return;
            }
        }
        System.out.println("Product not found.");
    }
}