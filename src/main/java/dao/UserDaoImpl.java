package dao;

import com.example.mockito.User;

import java.awt.*;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl {

    private final List<User> userList = new ArrayList<>();

    public UserDaoImpl() {
        userList.add(new User("Maks"));
        userList.add(new User("Helena"));
        userList.add(new User("Olga"));
        userList.add(new User("Grisha"));
    }


    public User getUserByName(String name) {
        return userList.stream().filter(o -> o.getName().equals(name)).findFirst().orElse(null);
    }


    public List<User> findAllUsers() {
        return userList;
    }
}
