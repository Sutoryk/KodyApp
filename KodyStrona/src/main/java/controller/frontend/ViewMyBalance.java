package controller.frontend;

import dao.DatabaseConnection;
import entity.Kody;
import entity.Users;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/frontend/ViewMyBalanceservlet")
public class ViewMyBalance extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String a = request.getParameter("email");
        out.println("<a href='user_login_screen.jsp'>Wroc</a>");
        out.println("<h1>Employees List</h1>");
        List<Users> list = DatabaseConnection.checkBalance(a);
        out.print("<table border='1' width='100%' ");
        out.print("</th><th>Kod</th><th>Wartość kodu</th>");

        for (Users e : list) {
            out.print("<tr><td>" + e.getEmail() + "</td>" +
                    "<td>" + e.getBalance()+"</td></tr> ");

        }
        out.print("</table>");
        out.close();
    }

}


