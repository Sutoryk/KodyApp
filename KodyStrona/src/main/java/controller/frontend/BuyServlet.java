package controller.frontend;

import dao.DatabaseConnection;
import dao.KodyDAO;
import dao.UserDAO;
import entity.Kody;
import entity.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Random;

import static java.lang.System.out;

@WebServlet("/frontend/BuyServlet")
public class BuyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter in = response.getWriter();
        int value = Integer.valueOf(request.getParameter("value"));
        Random rn = new Random();
        int value2 = rn.nextInt((10000000 - 9000000) + 1) + 9000000;
        int i = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/storedb", "admin", "Password123#");
            PreparedStatement ps = con.prepareStatement("insert into kody(kod,value) values (?,?)");
            ps.setInt(1,value2);
            ps.setInt(2, value);

            i = ps.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("value", value);
        String homepage = "redeemed.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(homepage);
        dispatcher.forward(request,response);
                }

}
