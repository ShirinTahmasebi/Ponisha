package ir.ac.sbu.springponisha.service.impl;

import ir.ac.sbu.springponisha.dao.UserDao;
import ir.ac.sbu.springponisha.dao.model.User;
import ir.ac.sbu.springponisha.service.UserManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserManagerImpl implements UserManager {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUser(int userId) {
        return userDao.getUser(userId);
    }

    @Override
    public User getUser(String userName) {
        return userDao.getUser(userName);
    }

    @Override
    public User getUser(String userName, String password) {
        return userDao.getUser(userName, password);
    }

    @Override
    @Transactional
    public void insertUser(User user) {
        userDao.insertUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user, User oldUser) {
        userDao.updateUser(user, oldUser);
    }

    @Override
    public User getUserByResumeId(int resumeId) {
        return userDao.getUserByResumeId(resumeId);
    }

}
