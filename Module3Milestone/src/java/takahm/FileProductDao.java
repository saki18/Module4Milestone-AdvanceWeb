/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takahm;

import edu.lcc.citp.utility.CollectionFileStorageUtility;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Takahashi
 */
public class FileProductDao implements DataAccessObject<Product>{

    @Override
    public void create(Product Entity) {
    
         List<Product> pList = readAll();

        if (getProduct(Entity.getUpc()) != null) {
            System.out.println("Product already exists.");
        } else {
            pList.add(Entity);
            Collections.sort(pList);
            CollectionFileStorageUtility.save(pList, Product.class);
        }

        
    }

    @Override
    public Product read(Object id) {
        
    Product matchP = null;
        for (Product p: readAll()) {
            if (Product.getUpc().equals(id)) {
                matchP = p;
            }
        }

        return matchP;
    }

    @Override
    public List<Product> readAll() {
    
    return new ArrayList<>(CollectionFileStorageUtility.load(Product.class));
    
    }

    @Override
    public void update(Product Entity) {
        
   List<Product> pList = readAll();

        Product matchP = null;
        for (Product pElement : pList) {
            if (pElement.getUpc().equals(Entity.getUpc())) {
                matchP = pElement;
            }
        }

        if (matchP == null) {
            System.out.println("Product not found.");
        } else {
            if (Entity.getLongDetails() != null) {
                matchP.setLongDetails(Entity.getLongDetails());
            }
            if (Entity.getPrice() != null) {
                matchP.setPrice(Entity.getPrice());
            }
            if (Entity.getShortDetails() != null) {
                matchP.setShortDetails(Entity.getShortDetails());
            }
            if (Entity.getStock() != null) {
                matchP.setStock(Entity.getStock());
            }

            CollectionFileStorageUtility.save(pList, edu.lcc.citp.inventory.Product.class);
        }

    }

    @Override
    public void delete(Object id) {
        
          List<Product> pList = readAll();

        Product matchP = null;
        for (Product p : pList) {
            if (p.getUpc().equals(id)) {
                matchP = p;
                break;
            }
        }

        if (matchP == null) {
            System.out.println("Product not found.");
        } else {
            pList.remove(matchP);
            CollectionFileStorageUtility.save(pList,Product.class);
        }

    }
}
