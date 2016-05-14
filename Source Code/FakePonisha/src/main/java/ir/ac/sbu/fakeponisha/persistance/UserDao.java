package ir.ac.sbu.fakeponisha.persistance;

import ir.ac.sbu.fakeponisha.model.User;
import java.util.List;

public interface UserDao {

    public List<User> getAllUsers();

    public User getUser(int userId);

    public void insertUser(User user);

    public void updateUser(User user);
}
