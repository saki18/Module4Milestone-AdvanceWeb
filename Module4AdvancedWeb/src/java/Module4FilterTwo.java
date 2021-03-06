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
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This joint right here, it's going to display the current time for each
 * request.
 */
@WebFilter("/*")
public class Module4FilterTwo implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        response.getWriter().print("<p>Current Time:" + df.format(Calendar.getInstance().getTime()) + "</p>");

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
