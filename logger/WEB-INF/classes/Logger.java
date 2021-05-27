
import java.io.*;
import java.util.*;
import java.security.*;
import javax.servlet.*;
import javax.servlet.http.*;

public final class Logger implements Filter {

    private FilterConfig filter = null;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String web = "Internet Explorer";
        String name = "";
        String username = "Unknown";
        Date date = new Date();
        long startTime = System.currentTimeMillis();
        String getAddress = request.getRemoteAddr();
        String fileRequest = ((HttpServletRequest) request).getRequestURI();
        String hostRequest = ((HttpServletRequest) request).getRemoteHost();
        String filename = "D:\\Algonquin College\\Level 4\\Java Applications\\Labs\\Assignment 2\\apache-tomcat-8.5.64-windows-x64\\apache-tomcat-8.5.64\\webapps\\logger\\WEB-INF\\lib\\folder.txt";
        PrintWriter print = response.getWriter();

        try {
            FileWriter filewriter = new FileWriter(filename, true);
            filewriter.write("User access at " + date.toString() + "User access at " + date.toString() + " Authentication type: " + name + " User name: " + username + " User IP: " + getAddress + " Accessing: " + fileRequest + " Host: " + hostRequest + " Browser: " + web + " Milliseconds used: " + (System.currentTimeMillis() - startTime));
            filewriter.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        chain.doFilter(request, response);

        response.setContentType(
                "text/html");

        print.println(
                "<BR>");
        print.println(
                "<BR>");
        print.println(
                "<BR>");
        print.println(
                "<BR>");
        print.println(
                "<HR>");
        print.println(
                "<CENTER>");
        print.println(
                "<FONT SIZE = 3>");
        print.println(
                "<I>");
        print.println(
                "Your access to this page has been logged.");
        print.println(
                "</I>");
        print.println(
                "</FONT>");
        print.println(
                "</CENTER>");
        String type = ((HttpServletRequest) request).getAuthType();
        if (type
                != null) {
            Principal principal = ((HttpServletRequest) request).getUserPrincipal();
            name = type;
            username = principal.getName();
        }

        filter.getServletContext()
                .log("User access at " + date.toString() + " Authentication type: " + name + " User name: " + username + " User IP: " + getAddress + " Accessing: " + fileRequest + " Host: " + hostRequest + " Browser: " + web + " Milliseconds used: " + (System.currentTimeMillis() - startTime));
    }

    public void destroy() {
        filter = null;
    }

    public void init(FilterConfig filter) {
        this.filter = filter;
    }
}
