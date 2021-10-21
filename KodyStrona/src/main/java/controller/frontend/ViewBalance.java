package controller.frontend;

import entity.Kody;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import dao.DatabaseConnection;
import dao.RedeemDAO;
import entity.Users;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.UserServices;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static java.lang.System.out;

import java.io.IOException;

@WebServlet("/frontend/viewservlet")
public class ViewBalance extends HttpServlet{
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                String a = request.getParameter("email");
                out.println("<a href='user_login_screen.jsp'>Wroc</a>");
                out.println("<h1>Employees List</h1>");
                Kody kody = new Kody();
                List<Kody> list = DatabaseConnection.getKod(kody);
                out.print("<table border='1' width='100%' ");
                out.print("</th><th>Kod</th><th>Wartość kodu</th>");

                for (Kody e : list) {
                        out.print("<tr><td>" + e.getKod() + "</td>" +
                                "<td>" + e.getValue()+"</td></tr> ");

                }
                out.print("</table>");
                out.close();
        }

}