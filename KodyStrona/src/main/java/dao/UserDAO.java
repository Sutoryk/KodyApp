package dao;

import entity.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class UserDAO extends JpaDAO<Users> implements GenericDAO<Users> {

    public UserDAO(EntityManager entityManager) {

        super(entityManager);
    }


    public Users create(Users user){

        return super.create(user);

    }

    @Override
    public Users update(Users user) {
        return super.update(user);
    }

    @Override
    public Users get(Object user) {

        return super.find(Users.class, user);
    }

    @Override
    public void delete(Object id) {

        super.delete(Users.class, id);

    }

    @Override
    public List<Users> listAll() {
        return super.findWithNamedQuery("Users.findAll");
    }

    @Override
    public long count() {

        return super.countAll("Users.countAll");
    }

    public Users findByEmail(String email){

        List<Users> listUsers = super.findWithNamedQuery("Users.findByEmail", "email", email);
        if(listUsers.size()>0){
            return listUsers.get(0);
        }
    return null;

    }

}
