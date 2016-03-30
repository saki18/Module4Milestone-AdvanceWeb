/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takahm;

import edu.lcc.citp.utility.CollectionFileStorageUtility;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Takahashi
 */
    public class FileUserDao implements DataAccessObject<User>{

        @Override
        public void create(User entity) {
        
        // this will create the Product List
        List<Product> pList = getProductList();

        if (getProduct(p.getUpc()) != null) {
            System.out.println("Product already exists.");
        } else {
            pList.add(p);
            Collections.sort(pList);
            CollectionFileStorageUtility.save(pList, Product.class);
        }

    }

    @Override
    public User read(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(User Entity) {
       
    }

    @Override
    public void delete(Object id) {
        
    }
        
        
        }

        @Override
        public User read(Object id) {
         
        Product matchP = null;
        for (p: readAll()) {
            if (p.getUpc().equals(Upc)) {
                matchP = p;
            }
        }

        return matchP;
        


}

        @Override
        public List<User> readAll() {
            
        return new ArrayList<>(CollectionFileStorageUtility.load(Product.class));
        
}

        @Override
        public void update(User Entity) {
            List<Product> pList = readAll();

        matchP = null;
        for (pElement : pList) {
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

            CollectionFileStorageUtility.save(pList);
        }

}

        @Override
        public void delete(Object id) {
       
        List<Product> pList = readAll();

        matchP = null;
        for (p: pList) {
            if (p.getUpc().equals(upc)) {
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