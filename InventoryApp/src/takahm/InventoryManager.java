/*
 * Masaki Takahashi
 * CITP 290 - Advanced JAVA.
 * Module 1 Project 
 * Feb 2, 2016 
 */
package takahm;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import edu.lcc.citp.utility.CollectionFileStorageUtility;
import java.io.Serializable;
import java.math.BigDecimal;

public class InventoryManager {
    
    
   public List<Product> getProductList() {
       List<Product> products=new ArrayList<>(); //originally I had null but this was 
       // incorrect because of the following code below needed to create a new ArrayList
       // because it was a list. 
       
       try {
           products.addAll(CollectionFileStorageUtility.load(Product.class));
           // (Product.class) was not able to implement until I had coded stabilization
           // in the Product Java. All lists are collections as they inherit from 
           // collection. 
           
       // Initializes a new instance of the StackTrace class from the caller's frame. 
       // The catch block contains code that is executed if and when the exception 
       // handler is invoked.
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
       return products;
   }
   
   public Product getProduct(String upc)
   {
       List<Product> products = getProductList();
       for (Product pro : products) {
           if (pro.getUpc().equals(upc)) {
               return pro;
           }
       }
       return null;

   }
   // this part of the code will call for adding product to the array list. 
   public void addProduct(Product p)
   {
       List<Product> products = getProductList();
       if(products!=null)
       {
           for (Product pro : products)
           {
               if (pro.getUpc().equals(p.getUpc()))
               {
                   System.out.println("A product with given upc alredy exist,cannot duplicate upc");
                   return;
               }
           }
       }
       else
       {
           products=new ArrayList<Product>();
       }
       products.add(p);
       // exception handler. 
       try
       {
           CollectionFileStorageUtility.save(products, Product.class);
       }
       catch (IOException e)
       {
       }
   }

   // this will update product. 
   public void updateProduct(Product p)
   {
       List<Product> products = getProductList();
       if(products==null)
       {
           
       }
       else
       {
           for (Product pro : products)
           {
               if (pro.getUpc().equals(p.getUpc()))
               {
                   if (!p.getLongDetails().isEmpty())
                   {
                       pro.setLongDetails(p.getLongDetails());
                   }
                   if (p.getPrice()!=null)
                   {
                       pro.setPrice(p.getPrice());
                   }
                   if (!p.getShortDetails().isEmpty())
                   {
                       pro.setShortDetails(p.getShortDetails());
                   }
                   if (pro.getStock()!=0)
                   {
                       pro.setStock(p.getStock());
                   }
                   return;
               }
           }
           System.out.println("A product with given upc does not exist");
       }
      
   }

   public void removeProduct(String upc)
   {
       List<Product> products = getProductList();
       if(products==null)
       {
           
       }
       else
       {
           for (Product pro : products)
           {
               if (pro.getUpc().equals(upc))
               {
                   products.remove(pro);
                   return;
               }
           }
           System.out.println("A product with given upc does not exist");
       }
      
   }
}
