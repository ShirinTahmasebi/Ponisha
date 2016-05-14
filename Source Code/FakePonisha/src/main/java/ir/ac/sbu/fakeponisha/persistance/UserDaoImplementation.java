package ir.ac.sbu.fakeponisha.persistance;

import ir.ac.sbu.fakeponisha.model.User;
import ir.ac.sbu.fakeponisha.utils.Tag;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class UserDaoImplementation implements UserDao {

    private static EntityManager em;

    @Override
    public List<User> getAllUsers() {
        EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory(Tag.PERSISTANCE_UNIT_NAME);
        em = emf.createEntityManager();
        TypedQuery<User> allUsers = em.createNamedQuery("User.findAll", User.class);
        return allUsers.getResultList();
    }

    @Override
    public User getUser(int userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertUser(User user) {
        EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory(Tag.PERSISTANCE_UNIT_NAME);
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    @Override
    public void updateUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
