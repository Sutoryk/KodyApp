package dao;

import entity.Kody;
import jakarta.persistence.EntityManager;

import java.util.List;

public class KodyDAO extends JpaDAO<Kody> implements GenericDAO<Kody>{

    public KodyDAO(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Kody create(Kody kody) {
        return super.create(kody);
    }

    @Override
    public Kody find(Class<Kody> type, Object id) {
        return super.find(type, id);
    }

    @Override
    public void delete(Object kod_id) {
        super.delete(Kody.class, kod_id);
    }

    @Override
    public long countAll(String queryName) {
        return super.countAll(queryName);
    }

    @Override
    public Kody update(Kody kody) {
        return null;
    }

    @Override
    public Kody get(Object kod_id) {
        return super.find(Kody.class,kod_id);
    }


    @Override
    public List<Kody> listAll() {
        return super.findWithNamedQuery("Kody.findAll");
    }

    @Override
    public long count() {
        return 0;
    }

    public Kody findByCode(Integer kod){

        List<Kody> listUsers = super.findWithNamedQuery("Kody.findByKod", "kod", kod);
        for(Kody kodyy:listUsers){
            System.out.println(kodyy.getKod_id());
        }
        return listUsers.get(0);
    }

}
