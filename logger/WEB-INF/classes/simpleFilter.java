import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.Filter;


public class simpleFilter implements Filter{
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request, response);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("This filter is written by Dhruv and Vyom.");
    }
    public void destroy(){
        
    }
    public void init(FilterConfig config){
        
    }
}