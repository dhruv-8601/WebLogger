
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.Filter;

public class verification implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String password = ((HttpServletRequest) request).getParameter("password");
        if (password.equals("abc123")) {
            chain.doFilter(request, response);
        } else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<HTML>");
            out.println("<HEAD>");
            out.println("<TITLE>");
            out.println("Incorrect Password");
            out.println("</TITLE>");
            out.println("</HEAD>");
            out.println("<BODY>");
            out.println("<H1>Incorrect Password</H1>");
            out.println("Sorry, that password was incorrect.");
            out.println("</BODY>");
            out.println("</HTML>");
        }
    }

    public void destroy() {

    }

    public void init(FilterConfig config) {

    }
}
