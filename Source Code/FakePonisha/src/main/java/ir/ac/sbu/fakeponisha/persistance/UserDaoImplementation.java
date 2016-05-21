package ir.ac.sbu.fakeponisha.persistance;

import ir.ac.sbu.fakeponisha.model.User;
import ir.ac.sbu.fakeponisha.utils.Tag;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class UserDaoImplementation implements UserDao {

    private EntityManagerFactory emf;

    @Override
    public List<User> getAllUsers() {
//        EntityManager em;
//        emf = Persistence.createEntityManagerFactory(Tag.PERSISTANCE_UNIT_NAME);
//        em = emf.createEntityManager();
        EntityManager em;
        em = getEntityManager(emf);
        TypedQuery<User> allUsers = em.createNamedQuery("User.findAll", User.class);
        return allUsers.getResultList();
    }

    @Override
    public User getUser(int userId) {
//        EntityManagerFactory emf;
//        emf = Persistence.createEntityManagerFactory(Tag.PERSISTANCE_UNIT_NAME);
//        em = emf.createEntityManager();
        EntityManager em;
        em = getEntityManager(emf);
        TypedQuery<User> user = em.createNamedQuery("User.findByUserId", User.class);
        user.setParameter(1, userId);
        try {
            return user.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException e) {
            return user.getResultList().get(0);
        }
    }

    @Override
    public void insertUser(User user) {
//        EntityManagerFactory emf;
//        emf = Persistence.createEntityManagerFactory(Tag.PERSISTANCE_UNIT_NAME);
//        em = emf.createEntityManager();
        EntityManager em;
        em = getEntityManager(emf);
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    @Override
    public void updateUser(User oldUser, User newUser) {
        EntityManager em;
        em = getEntityManager(emf);
        em.getTransaction().begin();
        oldUser = em.merge(oldUser);
        oldUser.setUserFirstLastName(newUser.getUserFirstLastName());
        oldUser.setBirthDate(newUser.getBirthDate());
        oldUser.setCity(newUser.getCity());
        oldUser.setEmail(newUser.getEmail());
        em.getTransaction().commit();
    }

    @Override
    public User getUser(String userName) {
//        EntityManagerFactory emf;
//        emf = Persistence.createEntityManagerFactory(Tag.PERSISTANCE_UNIT_NAME);
//        em = emf.createEntityManager();
        EntityManager em;
        em = getEntityManager(emf);
        TypedQuery<User> user = em.createNamedQuery("User.findByUsername", User.class);
        user.setParameter(1, userName);
        try {
            return user.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException e) {
            return user.getResultList().get(0);
        }
    }

    @Override
    public User getUser(String userName, String password) {
//        EntityManagerFactory emf;
//        emf = Persistence.createEntityManagerFactory(Tag.PERSISTANCE_UNIT_NAME);
//        em = emf.createEntityManager();
        EntityManager em;
        em = getEntityManager(emf);
        TypedQuery<User> user = em.createNamedQuery("User.findByUsernamePassword", User.class);
        user.setParameter(1, userName);
        user.setParameter(2, password);
        try {
            return user.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException e) {
            return user.getResultList().get(0);
        }
    }

    private EntityManager getEntityManager(EntityManagerFactory emf) {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory(Tag.PERSISTANCE_UNIT_NAME);
        }
        return emf.createEntityManager();
    }

}
