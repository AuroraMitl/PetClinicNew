package servlets;


import com.aurora.petClinic.jdbcConnect.JdbcConnect;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/clients/editClient")

public class EditClientServlet extends HttpServlet {
    public EditClientServlet() {
        super();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
      /*  String path = "/showFormForEditClient.html";
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);*/
        String clientNameForEdit = request.getParameter("clientNameForEdit");

        PrintWriter writer = response.getWriter();
        writer.println("<!DOCTYPE HTML>");
        writer.println("<html lang=\"en\" xmlns:th=\"http://www.thymeleaf.org\">");
        writer.println("<head>");
        writer.println(" <meta charset=\"utf-8\">");
        writer.println(" <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">");
        writer.println(" <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css\" integrity=\"sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS\" crossorigin=\"anonymous\">");
        writer.println("  <title>Edit Client</title>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<div class=\"container\">");
        writer.println("<h3>Edit client</h3>");
        writer.println("<hr>");
        writer.println("<p class=\"h4 mb-4\">Edit client</p>");
        writer.println("<form action=\"editClient\" method=\"POST\">");
        writer.println(" Client name<input type=\"text\" name=\"clientNewName\" placeholder=\"Client name\">");

        writer.println ("<input type=\"hidden\" name=\"clientNameForEdit\" value=\""+clientNameForEdit+"\"/>");

        writer.println("<button type=\"submit\">Edit</button>");
        writer.println(" </form>");
        writer.println("<hr>");
        writer.println("<a href=\"/clients\">Back to client's list</a>");
        writer.println("</div>");
        writer.println("</body>");
        writer.println("</html>");



    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String clientNewName = request.getParameter("clientNewName");
        String clientNameForEdit = request.getParameter("clientNameForEdit");
        try {
            JdbcConnect.editClient(clientNameForEdit, clientNewName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/clients");
    }


}
