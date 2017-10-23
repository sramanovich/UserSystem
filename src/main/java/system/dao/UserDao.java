package system.dao;

import system.model.User;

import java.util.List;

/**
 * Created by Administrator on 23.10.2017.
 */
public interface UserDAO {

    public List<User> getAllUsers();

    public void addUser(User user);

    public void deleteUser(Integer id);
}
