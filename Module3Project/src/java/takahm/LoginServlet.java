/*
 * Masaki Takahashi
 * CITP 290 - Advance Java Programming for Business. 
 * April 12, 2016 
 * Instructor: Zach Hoffman
 * The following program is part of a fullfiment for CITP 290, the following program 
 * will allow the user to create, edit, update, delete, and read the data product list 
 * through a web interface. 
 */
package takahm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Takahashi
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession httpSession = req.getSession();
        DataAccessObject<User> userDao = DataAccessObjectFactory.getUserDao();
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username != null && password != null) {
            for (User u : userDao.readAll()) {
                if (username.equalsIgnoreCase(u.getUsername())
                        && password.equals(u.getPassword())) {
                    httpSession.setAttribute("currentUser", u);
                    resp.sendRedirect("inventory.jsp");
                }
            }
        } else if (req.getParameter("logout").equals("true")) {
            httpSession.setAttribute("currentUser", null);
            resp.sendRedirect("login.jsp");
        } else {
            resp.sendRedirect("login.jsp?failed=true");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("users.jsp");
    }

}