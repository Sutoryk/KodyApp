package dao;

import entity.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.Test;
import service.UserServices;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {

    @Test
    void create() {
        Users user1 = new Users();

        user1.setEmail("najnowszy@gmail.pl");
        user1.setPassword("sadsadasddfgdfasd");
        user1.setBalance(00.00);
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        UserDAO userDAO = new UserDAO(entityManager);
        user1 = userDAO.create(user1);

        entityManager.close();
        entityManagerFactory.close();


        assertTrue(user1.getUser_id() > 0);
        System.out.println("Transakcja przebiegła pomyślnie");

    }

    @Test
    public void testGetUsers(){
        Integer userID = 5;

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        UserDAO userDAO = new UserDAO(entityManager);

        Users user = userDAO.get(userID);
        if(user !=null) {
            System.out.println(user.getEmail());
        }

        assertNotNull(user);

    }
    @Test
    public void testUserNotFound(){
        Integer userID =271;
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        UserDAO userDAO = new UserDAO(entityManager);

        Users user = userDAO.get(userID);
        System.out.println(user.getEmail());

        assertNull(user);


    }

    @Test

    public void testDelete(){
        Integer userID =7;
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        UserDAO userDAO = new UserDAO(entityManager);

        userDAO.delete(userID);

        Users user = userDAO.get(userID);

        assertNull(user);



    }
    //@Test(expected = EntityNotFoundException.class) // kiedy wiemy ,ze bedzie ten blad( bo np nie ma wa w bazie tego rekordu)
    @Test

    public void testListAll(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        UserDAO userDAO = new UserDAO(entityManager);

        List<Users> listUsers = userDAO.listAll();
        assertTrue(listUsers.size()>0);
       for(Users user: listUsers){
           System.out.println(user.getEmail());

       }


    }
    @Test
    public void testCountAll(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        UserDAO userDAO = new UserDAO(entityManager);

        long users = userDAO.count();
        System.out.println(users);
        assertEquals(4,users);

    }

    @Test

    public void testFindByEmail(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String email = "admin";
        UserDAO userDAO = new UserDAO(entityManager);
        Users user = userDAO.findByEmail(email);
        System.out.println(user.getBalance());
        assertNotNull(user);

    }
    @Test
    public void addBalance(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        UserDAO userDAO = new UserDAO(entityManager);

        Users user = userDAO.get(266);
        user.setBalance(200.00);
        userDAO.update(user);
        }

}