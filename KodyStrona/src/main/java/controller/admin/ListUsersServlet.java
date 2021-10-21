package controller.admin;

import entity.Users;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.ws.rs.core.Request;
import service.UserServices;

import java.io.IOException;
import java.util.List;

@WebServlet("/admin/list_users")
public class ListUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        String listPage = "user_list.jsp";
    RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);
    dispatcher.forward(request,response);



    }


}
