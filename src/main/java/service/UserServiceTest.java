package service;

import com.example.mockito.User;
import dao.UserDaoImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    private final UserDaoImpl userDaoMock = mock(UserDaoImpl.class);
    private UserService out;
    private static User HELENA;
    private static User MAKS;
    private final String NEW_USER_HELENA = "Helena";
    private final String NEW_USER_MAKS = "Maks";

    @BeforeEach
    public void createNewUser() {
        HELENA = new User(NEW_USER_HELENA);
        MAKS = new User(NEW_USER_MAKS);
    }

    @BeforeEach
    public void initOut() {
        out = new UserService(userDaoMock);
    }

    @Test
    void shouldFindUserBy() {
        when(userDaoMock.getUserByName(NEW_USER_HELENA)).thenReturn(HELENA);
        assertTrue(out.checkUserExist(HELENA));
    }

    @Test
    void shouldReturnNullIfUserNotExist() {
        when(userDaoMock.getUserByName(NEW_USER_MAKS)).thenReturn(null);
        assertFalse(out.checkUserExist(MAKS));
    }
}
