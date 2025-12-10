import group8.ets.Student;
import group8.ets.databases.StudentDatabase;
import group8.ets.services.AuthService;
import org.junit.Before;
import org.junit.Test;

public class StudentDatabaseTest {

    @Before
    public void setUp() {
        AuthService.getInstance().register("a", "a", "a");
        AuthService.getInstance().register("b", "b", "b");
        AuthService.getInstance().register("c", "c", "c");
    }

    @Test
    public void studentDatabaseSizeTest() {
        int databaseSize = StudentDatabase.getInstance().getAllStudents().size();
        assert (databaseSize == 3); // At least the three students created above should be in
    }

    @Test
    public void retrieveStudentByEmailTest() {
        Student retrievedStudent = StudentDatabase.getInstance().getStudentByEmail("a");
        assert (retrievedStudent != null);
        assert (retrievedStudent.getName().equals("a"));
    }
}
