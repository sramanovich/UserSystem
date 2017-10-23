package system.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.dao.UserDAO;
import system.dao.UserDAOImpl;
import system.model.User;

import java.util.List;
//@ImportResource("classpath:spring.xml")

/**
 * Created by Administrator on 19.10.2017.
 */
@Service
@Transactional
public class UserServiceImpl /*implements UserService*/ {
    @Autowired
    private UserDAOImpl userdao;

    //private SessionFactory sessionFactory;

    /*public UserServiceImpl(SessionFactory sessionFactory) {
        //this.sessionFactory = sessionFactory;
        userdao = new UserDAOImpl(sessionFactory);
    }*/

    public List getAllUsers() {
        return userdao.getAllUsers();
    }

    public boolean checkUser(User user) {
        return userdao.checkUser(user);
    }

    public void addUser(User user)
    {
        userdao.addUser(user);
    }

    public void deleteUser(Integer id)
    {
        userdao.deleteUser(id);
    }
}
