package dao;

import com.example.mockito.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserDaoTest {
    private final String HELENA = "Helena";
    private final String MAKS = "Maks";
    private final List<User> USER_LIST = new ArrayList(Arrays.asList(new User("Stepan"), new User("Jonny"), new  User ("Ron")));
    UserDaoImpl userDao;
    @BeforeEach
    private void createNewUser() {
        userDao = new UserDaoImpl();
    }

    @Test
    void shouldFindUserByNameIfExist() {
        Assertions.assertEquals(HELENA, userDao.getUserByName(HELENA));
    }

    @Test
    void shouldReturnNullIfUserNotExist() {
        Assertions.assertNull(null, (Supplier<String>) userDao.getUserByName(MAKS));
    }

    @Test
    void findAllUsers() {
        Assertions.assertEquals(USER_LIST, userDao.findAllUsers());
    }

}

