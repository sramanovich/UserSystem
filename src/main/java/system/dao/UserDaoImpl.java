package system.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import system.model.User;

import java.util.List;

import java.util.Arrays;


//@ImportResource("classpath:spring.xml")

/**
 * Created by Administrator on 18.10.2017.
 */
@Repository
@Transactional
public class UserDAOImpl /*implements UserDAO*/{
    private List<User> users = Arrays.asList(new User("admin", "admin"),
                                            new User("user1", "user1"));

    @Autowired
    private SessionFactory sessionFactory;

    /*public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }*/

    public List<User> getAllUsers() {
        if (sessionFactory != null ) {
            List<User> listUser = (List<User>) sessionFactory.getCurrentSession()
                    .createCriteria(User.class)
                    .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
            return listUser;
        }

        return users;
    }

    public boolean checkUser(User user) {
        return true;
    }

    public void addUser(User user) {

    }

    public void deleteUser(Integer id) {

    }
}
