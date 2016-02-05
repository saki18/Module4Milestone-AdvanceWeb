/*
 * Masaki Takahashi
 * CITP 290 - Advanced JAVA.
 * Module 1 Project 
 * Feb 2, 2016 
 */
package takahm;
import java.math.BigDecimal;
import java.io.Serializable;

/**
 *
 * @author Takahashi
 */
public class Product implements Serializable {
    // serializable - its main purpose is to save the state of an object in order
    // to be able to recreate it when needed.
    
    private String upc;     
      
    private String shortDetails; 
    
    private String longDetails; 
    
    private BigDecimal price; 
 
    private int stock; 

    public String getUpc() {
        return upc;
    }

    // this is where i insert source code. 
    // to do this go to source>insert source code. 
    // the following will be the getters & setters. 
    
    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getShortDetails() {
        return shortDetails;
    }

    public void setShortDetails(String shortDetails) {
        this.shortDetails = shortDetails;
    }

    public String getLongDetails() {
        return longDetails;
    }

    public void setLongDetails(String longDetails) {
        this.longDetails = longDetails;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
 
 }
