package ir.ac.sbu.springponisha.dao.impl;

import ir.ac.sbu.springponisha.dao.UserDao;
import ir.ac.sbu.springponisha.dao.model.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImplementation implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> allUsers = entityManager.
                createNamedQuery("User.findAll", User.class);
        return allUsers.getResultList();
    }

    @Override
    public User getUser(int userId) {
        TypedQuery<User> user = entityManager.
                createNamedQuery("User.findByUserId", User.class);
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
    public User getUser(String userName) {
        TypedQuery<User> user = entityManager.
                createNamedQuery("User.findByUsername", User.class);
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
        TypedQuery<User> user = entityManager.
                createNamedQuery("User.findByUsernamePassword", User.class);
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

    @Override
    public void insertUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user, User oldUser) {
        oldUser = entityManager.merge(oldUser);
        oldUser.setUserFirstLastName(oldUser.getUserFirstLastName());
        oldUser.setBirthDate(oldUser.getBirthDate());
        oldUser.setCity(oldUser.getCity());
        oldUser.setEmail(oldUser.getEmail());
        oldUser.getResumeId().setResumeDescription(
                oldUser.getResumeId().getResumeDescription()
        );
    }

    @Override
    public User getUserByResumeId(int resumeId) {
        TypedQuery<User> user = entityManager.
                createNamedQuery("User.findByResumeId", User.class);
        user.setParameter(1, resumeId);
        try {
            return user.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException e) {
            return user.getResultList().get(0);
        }
    }
}
