package dao;

import entity.Kody;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class KodyDaoTest {
    @Test
    void create() {
        Kody kod = new Kody();
        Random rn = new Random();
        kod.setKod(rn.nextInt((10000000 - 9000000) + 1) + 9000000);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        KodyDAO kodyDAO = new KodyDAO(entityManager);
        kod = kodyDAO.create(kod);

        entityManager.close();
        entityManagerFactory.close();


        System.out.println("Transakcja przebiegła pomyślnie");

    }

    @Test
    void delete(){
       Integer kodId = 2;
       Kody kod = new Kody();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        KodyDAO kodyDAO = new KodyDAO(entityManager);
        kodyDAO.delete(kodId);


    }
    @Test
    void get(){
        Integer kodId = 3;
        Kody kod = new Kody();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        KodyDAO kodyDAO = new KodyDAO(entityManager);
        System.out.println(kodyDAO.get(3));



    }
    @Test
    void countall(){
        Integer kodId = 3;
        Kody kod = new Kody();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        KodyDAO kodyDAO = new KodyDAO(entityManager);
        List<Kody> kodList = kodyDAO.listAll();

        for(Kody koood: kodList){
            System.out.println(koood.getKod_id());

        }

    }

    @Test
    ///// usuwa element pod tym kodem
    void deleteElementByKod(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Integer kod = 9445830;
        KodyDAO kod2 = new KodyDAO(entityManager);
        System.out.println(kod2.findByCode(kod));
        Kody kod3 = kod2.findByCode(kod);
        Integer kod4 = kod3.getKod_id();
        kod2.delete(kod4);

    }


}