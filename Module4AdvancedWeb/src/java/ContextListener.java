/* Author: Masaki Takahashi 
 * Class: CITP 290 Advanced Java
 * Date: April 23, 2016
 * Instructor: Zach Hoffman
 * Abstract: Advanced Web Features - this application will display session open 
 * time, current time and start time. 
 */

/**
 *
 * @author Takahashi
 */
import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("The application started:");
        String startTime = System.currentTimeMillis() + "";
        /*
         event.getServletContext().setAttribute("servletLoadTime", Starttime);
         */
        ServletContext servCtx = event.getServletContext();
        servCtx.setAttribute("startTime", startTime);

        System.out.println(startTime);

    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        System.out.println("The application finished:");
        String finishTime = System.currentTimeMillis() + "";

        ServletContext servCtx = event.getServletContext();
        servCtx.setAttribute("finishTime", finishTime);

        System.out.println(finishTime);

    }

}
