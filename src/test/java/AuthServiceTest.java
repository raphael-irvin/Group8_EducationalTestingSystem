import group8.ets.services.AuthService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AuthServiceTest {

    @Before
    public void setUp() {
        AuthService.getInstance().register("a", "a", "a");
        AuthService.getInstance().register("b", "b", "b");
    }

    @Test
    public void registerTest_Success() {
        assertTrue(AuthService.getInstance().register("newemail", "newpassword", "newname"));
    }

    @Test
    public void registerTest_Failure_DuplicateEmail() {
        assertFalse(AuthService.getInstance().register("a2", "a", "newname"));
    }

    @Test
    public void loginTest_Success() {
        assertTrue(AuthService.getInstance().login("a", "a"));
    }

    @Test
    public void loginTest_Failure_WrongPassword() {
        assertFalse(AuthService.getInstance().login("a", "wrongpassword"));
    }

    public void loginTest_Failure_NonExistentUser() {
        assertFalse(AuthService.getInstance().login("nonexistent", "nopassword"));
    }

}
