package service;

import com.example.mockito.User;
import dao.UserDaoImpl;

public class UserService {

    private final UserDaoImpl userDao;

    public UserService(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    public boolean checkUserExist(User user) {
        User userByName = userDao.getUserByName(user.getName());
        return userByName != null;
    }
}
