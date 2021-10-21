package entity;

import dao.KodyDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KodyTestdasdsad {

    @Test
    void setKod() {
        Kody kody = new Kody();
        kody.setKod(465656);
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        KodyDAO kodyDAO = new KodyDAO(entityManager);
        Kody createdCode = kodyDAO.create(kody);

        entityManager.close();
        entityManagerFactory.close();


        assertTrue(createdCode.getKod_id() > 0);
        System.out.println("Transakcja przebiegła pomyślnie");
    }
}