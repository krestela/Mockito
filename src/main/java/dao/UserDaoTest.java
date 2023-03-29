package dao;

import com.example.mockito.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserDaoTest {

    private static User user;
    private static final UserDaoImpl out = mock(UserDaoImpl.class);

    private final String HELENA = "Helena";
    private final String MAKS = "Maks";
    private final String OLGA = "Olga";
    private final List<User> users = List.of(new User(HELENA), new User(MAKS),
            new User(OLGA));

    @BeforeEach
    void createNewUser() {
        user = new User(HELENA);
    }

    @Test
    void shouldFindUserByNameIfExist() {
        when(out.getUserByName(HELENA)).thenReturn(user);
        assertEquals(user, out.getUserByName(HELENA));
    }

    @Test
    void shouldReturnNullIfUserNotExist() {
        String GRISHA = "Grisha";
        when(out.getUserByName(GRISHA)).thenReturn(null);
        assertNull(out.getUserByName(GRISHA));
    }

    @Test
    void findAllUsers() {
        when(out.findAllUsers()).thenReturn(users);
        assertEquals(out.findAllUsers(), users);
    }
}

