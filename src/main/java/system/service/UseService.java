package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.dao.UserDao;

import java.util.List;

/**
 * Created by Administrator on 19.10.2017.
 */
@Service
public class UseService {
    @Autowired
    private  UserDao userdao;

    public List getAllUsers() {
        return userdao.getAllUsers();
    }
}
