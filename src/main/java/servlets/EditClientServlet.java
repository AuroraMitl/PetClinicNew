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

@WebServlet("/clients/editClient")

public class EditClientServlet extends HttpServlet {
    public EditClientServlet() {
        super();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String path = "/showFormForAddClient.html";
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("clientName");
        JdbcConnect.editClient(name);
        response.sendRedirect("/clients");
    }


}
