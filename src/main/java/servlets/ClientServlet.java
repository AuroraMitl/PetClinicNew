package servlets;

import com.aurora.petClinic.jdbcConnect.JdbcConnect;
import com.aurora.petClinic.model.Client;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/clients")

public class ClientServlet extends HttpServlet {

    public ClientServlet() {
        super();
    }

    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
// Put your code here
    }

    public void doDelete(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
// Put your code here
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Client> clientsList = new ArrayList<>();
        try {
            clientsList = JdbcConnect.getAllClients();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<head>\n" +
                "    <!-- Required meta tags -->\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n" +
                "\n" +
                "    <!-- Bootstrap CSS -->\n" +
                "    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css\" integrity=\"sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS\" crossorigin=\"anonymous\">\n" +
                "\n" +
                "\t<title>Manager Directory</title>\n" +
                "</head>");
        writer.println("There will be List of All clients...");
        writer.println("<body>");
        writer.println("<div>");
        writer.println("<a href=\"/clients/addClient\" class=\"btn btn-primary btn-sm mb-3\">");
        writer.println("Add client");
        writer.println("</a>");
        writer.println("</div>");
        writer.println("<table class=\"table table-bordered table-striped\">");
        writer.println("<thead class=\"thead-dark\">");
        writer.println("<tr>\n" +
                "\t\t\t\t<th style=\"padding: 4px\">Client Name</th>\n" +
                "\t\t\t</tr>");
        writer.println("</thead>");
        writer.println("<tbody>");
        for (Client client : clientsList) {
            writer.println("<tr>");
            writer.println("<td style=\"padding: 4px\">");
            writer.println(client.getName() );
            writer.println("</td>");
            writer.println("</tr>");
        }
        writer.println("</tbody>");
        writer.println("</thead>");
        writer.println("</table>");
        writer.println("</body>");
    }

}










