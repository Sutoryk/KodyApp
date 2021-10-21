package service;

import dao.UserDAO;
import entity.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public class UserServices {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private UserDAO userDAO;
    private HttpServletRequest request;
    private HttpServletResponse response;

    public UserServices(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response=response;
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
        userDAO = new UserDAO(entityManager);
    }


    public List<Users> listUser() {
        List<Users> listUsers = userDAO.listAll();

        return listUsers;

    }

    public boolean loginUser(String email, String password) {
        Users existUser = userDAO.findByEmail(email);
        if (existUser != null) {
            return false;
        } else {
            return true;
        }


    }

    public Users findByEmail(String email) {
        List<Users> listUsers = userDAO.findWithNamedQuery("Users.findByEmail", "email", email);
        if (listUsers.size()>1) {
            return listUsers.get(0);
        }
        return null;


    }
    public void updateUser(){
        String email = request.getParameter("email");
        System.out.println(email);
    }
}