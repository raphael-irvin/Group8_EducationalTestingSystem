import group8.ets.Session;
import group8.ets.databases.StudentDatabase;
import group8.ets.services.AuthService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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

    @Test
    public void loginTest_Failure_NonExistentUser() {
        assertFalse(AuthService.getInstance().login("nonexistent", "nopassword"));
    }

    @Test
    public void sessionTest_AfterLogin() {
        AuthService.getInstance().login("b", "b");
        assertEquals(StudentDatabase.getInstance().getStudentByEmail("b"), Session.getInstance().getLoggedInStudent());
    }

}
