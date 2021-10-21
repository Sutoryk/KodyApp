package controller.frontend;

import dao.DatabaseConnection;
import dao.RedeemDAO;
import entity.Kody;
import entity.Users;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.UserServices;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static java.lang.System.out;

@WebServlet("/frontend/Redeem2Servlet")
public class Redeem2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType ("text/html");
        PrintWriter out = response.getWriter ();
        String email = request.getParameter ("email");
        Double value = (Double.valueOf(request.getParameter("wartosc")));
        Users e = new Users ();
        e.setBalance(value);
        e.setEmail(email);
        int status = DatabaseConnection.update (e);
        if (status > 0)
        {
            out.println ("Record updated succesfully...");
            response.sendRedirect ("viewservlet");
        }
        else
        {
            out.println ("Sorry! unable to update record");
        }
        out.close ();
    }


        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer n = (Integer.valueOf(request.getParameter("value")));


        if (RedeemDAO.validate(n)) {
            response.setContentType ("text/html");
            PrintWriter out = response.getWriter ();
            String email = request.getParameter ("email");
            Double value = (Double.valueOf(request.getParameter("wartosc")));
            Users e = new Users ();
            e.setBalance(value);
            e.setEmail(email);
            int status = DatabaseConnection.update (e);
            if (status > 0)
            {
                out.println ("Record updated succesfully...");
                RequestDispatcher rd = request.getRequestDispatcher("user_login_screen.jsp");
                request.getSession().setAttribute("value", n);
                rd.forward(request, response);
            }
            else
            {
                out.println ("Sorry! unable to update record");
            }
            out.close ();




        } else {
            out.print("Sorry username or password error");
            RequestDispatcher rd = request.getRequestDispatcher("redeemed.jsp");
            rd.include(request, response);
        }

        out.close();
    }
}

