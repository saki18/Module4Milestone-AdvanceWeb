/*
 * Masaki Takahashi
 * CITP 290
 * Milestone 2 
 * Java Web Application that allows you to view the list of products by running
 * your application and going to http://localhost:8080/store/inventory in a 
 * web browser on your computer.  You should be able to view and use the form for
 * adding products by going to http://localhost:8080/store/inventoryForm.html
 */
package takahm;

import edu.lcc.citp.inventory.InventoryManager;
import edu.lcc.citp.inventory.Product;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * InventoryServlet provides a web access to add and save new products to the 
 * product inventory and display the list of all saved products that was created.
 * 
 *
 * @author Takahashi 
 */
@WebServlet("/inventory")
public class InventoryServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        if (this.getServletContext().getAttribute("productDao") == null) {
            this.getServletContext().setAttribute("productDao", DataAccessObjectFactory.getProductDao());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataAccessObject<Product> invMan = (DataAccessObject<Product>) this.getServletContext().getAttribute("productDao");

        String button = req.getParameter("button");
        String upc = req.getParameter("upc");
        String shortDetails = req.getParameter("shortDetails");
        String longDetails = req.getParameter("longDetails");
        String price = req.getParameter("price");
        String stock = req.getParameter("stock");

        Product p = new Product();
        p.setUpc(upc);
        p.setShortDetails(shortDetails);
        p.setLongDetails(longDetails);
        if (price != null) {
            p.setPrice(new BigDecimal(price));
        }
        if (stock != null) {
            p.setStock(Integer.parseInt(stock));
        }

        switch (button) {
            case "Create":
                invMan.create(p);
                break;
            case "Edit":
                invMan.update(p);
                break;
            case "Delete":
                invMan.delete(upc);
                break;
        }

        resp.sendRedirect("inventory.jsp");
    }

}