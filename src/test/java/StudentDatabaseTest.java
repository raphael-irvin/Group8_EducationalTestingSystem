import group8.ets.Student;
import group8.ets.databases.StudentDatabase;
import org.junit.Test;

public class StudentDatabaseTest {

    Student student1 = new Student("Alice", "alice@gmail.com", "password123");
    Student student2 = new Student("Bob", "bob@gmail.com", "securepass");
    Student student3 = new Student("Charlie", "charlie@gmail.com", "charliepwd");

    @Test
    public void studentDatabaseSizeTest() {
        int databaseSize = StudentDatabase.getInstance().getAllStudents().size();
        assert (databaseSize == 3); // At least the three students created above should be in
    }

    @Test
    public void retrieveStudentByEmailTest() {
        Student retrievedStudent = StudentDatabase.getInstance().getStudentByEmail(student1.getEmail());
        assert (retrievedStudent != null);
        assert (retrievedStudent.getName().equals("Alice"));
    }
}
