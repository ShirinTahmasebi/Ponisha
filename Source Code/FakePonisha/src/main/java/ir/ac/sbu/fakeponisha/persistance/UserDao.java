package ir.ac.sbu.fakeponisha.persistance;

import ir.ac.sbu.fakeponisha.model.User;
import java.util.List;

public interface UserDao {

    /**
     *
     * @return
     */
    public List<User> getAllUsers();

    /**
     *
     * @param userId
     * @return
     */
    public User getUser(int userId);

    /**
     *
     * @param userName
     * @return
     */
    public User getUser(String userName);
    
    /**
     *
     * @param userName
     * @param password
     * @return
     */
    public User getUser(String userName, String password);

    /**
     *
     * @param user
     */
    public void insertUser(User user);

    /**
     *
     * @param user
     */
    public void updateUser(User user);
}
