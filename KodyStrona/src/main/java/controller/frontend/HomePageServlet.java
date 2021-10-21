package controller.frontend;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("")
public class HomePageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String homepage = "frontend/index.jsp";
            RequestDispatcher dispatcher = request.getRequestDispatcher(homepage);
            dispatcher.forward(request,response);
    }

}
