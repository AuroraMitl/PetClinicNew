package servlets;

import com.aurora.petClinic.jdbcConnect.JdbcConnect;
import com.aurora.petClinic.model.Client;
import com.aurora.petClinic.model.Pet;

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
        List<Pet> petsList = new ArrayList<>();
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
        writer.println("Hello our guests and their pets");

        writer.println("<body>");

       // String cssTag="<link rel='stylesheet' type='text/css' href='css/style.css'>";
        writer.println("<table class=\"table table-bordered table-striped\">");
        writer.println("<thead class=\"thead-dark\">");
        writer.println("<tr>\n" +
                "\t\t\t\t<th style=\"padding: 4px\">Client Name</th>\n" +
                "\t\t\t</tr>");
        writer.println("</thead>");

        writer.println("<tbody>");


      for (Client client : clientsList) {

          writer.println("<link href='style.css' rel='stylesheet' type='text/css'/>");
          writer.println("<table class=\"table table-bordered table-striped\">");
          writer.println("<div>");
          writer.println("<tr>");
          writer.println("<td>");
          writer.println(client.getName());

          writer.println("</td>");

          writer.println("<td>");
          try {
              petsList = JdbcConnect.getPetByClient(client.getName());
          } catch (ClassNotFoundException e) {
              e.printStackTrace();
          }
          for (Pet pet : petsList) {
              //    String clientNameForSearch;

              writer.println(pet.getPetName());

          }
          writer.println("</td>");
              writer.println("<td>");
              // writer.println("<div class='tabl'>");

              writer.println("<a href=\"/clients/deleteClient\" class=\"btn btn-primary btn-sm mb-3\">");
              writer.println("Delete client");
              writer.println("</a>");
              writer.println("<a href=\"/clients/editClient\" class=\"btn btn-primary btn-sm mb-3\">");
              writer.println("Edit client");
              writer.println("</a>");
              writer.println("</div>");
              writer.println("</td>");
              // writer.println("</div>");

              writer.println("</tr>");
              writer.println("</table >");

      }
    writer.println("</tbody>");
    writer.println("</thead>");
    writer.println("</table>");
    writer.println("</body>");
}


}










