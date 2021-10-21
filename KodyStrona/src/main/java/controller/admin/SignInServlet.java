package controller.admin;

import dao.DatabaseConnection;
import dao.JpaDAO;
import dao.LoginDao;
import dao.UserDAO;
import entity.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.resource.cci.ResultSet;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.UserServices;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

@WebServlet("/frontend/login_user")
public class SignInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String n = request.getParameter("email");
        String p = request.getParameter("password");
            if (LoginDao.validate(n, p)) {
                RequestDispatcher rd = request.getRequestDispatcher("user_login_screen.jsp");
                request.getSession().setAttribute("username", n);
                //request.getSession().setAttribute("balance", balance);

                rd.forward(request, response);

            } else {
                out.print("Sorry username or password error");
                RequestDispatcher rd = request.getRequestDispatcher("index.html");
                rd.include(request, response);
            }

            out.close();
    }
}

