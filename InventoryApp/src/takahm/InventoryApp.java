/* Masaki Takahashi 
 * Module 1 
 * 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takahm;
import java.util.Scanner;
import java.util.Arrays;
 
import java.util.Scanner;
public class InventoryApp {
   public static void main(String[] args) {
       while(true)
       {
           System.out.println("Enter add to add a product");
           System.out.println("Enter remove to remove a product");
           System.out.println("Enter update to update a product");
           System.out.println("Enter view to view a product");
           System.out.println("Enter quit to quit the menu");
           Scanner sc = new Scanner(System.in);
           String s="";
           s=sc.nextLine();
           if(s.equalsIgnoreCase("quit"))
           {
               break;
           }
           else if(s.equalsIgnoreCase("add")||s.equalsIgnoreCase("update"))
           {
               Product pro=new Product();
               System.out.println("Enter the upc of the product");
               String upc=sc.nextLine();
               pro.setUpc(upc);
               System.out.println("Enter the short detail of the product");
               String sDetail=sc.nextLine();
               pro.setShortDetails(sDetail);
               System.out.println("Enter the long detail of the product");
               String lDetail=sc.nextLine();
               pro.setLongDetails(lDetail);
               System.out.println("Enter the price of the product");
               java.math.BigDecimal price=sc.nextBigDecimal();
               pro.setPrice(price);
               System.out.println("Enter the stock of the product");
               int stock=sc.nextInt();
               pro.setStock(stock);
               InventoryManager inventory=new InventoryManager();
               if(s.equalsIgnoreCase("add"))
               {
                   inventory.addProduct(pro);
               }
               else if(s.equalsIgnoreCase("update"))
               {
                   inventory.updateProduct(pro);
               }
           }
           else if(s.equalsIgnoreCase("view")||s.equalsIgnoreCase("remove"))
           {
               System.out.println("Enter UPC of the product:");
               String upc=sc.nextLine();
               InventoryManager inventory=new InventoryManager();
               if(s.equalsIgnoreCase("view"))
               {
                   Product pro=inventory.getProduct(upc);
                   if(pro!=null)
                   {
                       System.out.println(pro.toString());
                   }
                   else
                   {
                       System.out.println("Error: UPC does not exist.");
                   }
               }
               else if(s.equalsIgnoreCase("remove"))
               {
                   inventory.removeProduct(upc);
               }
           }
       }
   }
}