//
//import entity.Users;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.Persistence;
//
//
//public class Main {
//
//    public static void main(String[] args){
//
//        Users user1 = new Users();
//
//        user1.setEmail("ayajjya@gmail.pl");
//        user1.setPassword("sdfssdfsfs");
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
//
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//
//        entityManager.getTransaction().begin();
//
//        entityManager.persist(user1);
//
//        entityManager.getTransaction().commit();
//        entityManager.close();
//        entityManagerFactory.close();
//
//        System.out.println("Transakcja przebiegła pomyślnie");
//
//    }
//}
