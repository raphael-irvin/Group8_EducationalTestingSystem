package group8.ets.database;

/*
CLASS INFORMATION:
The IStudentDatabase interface defines the contract for student database operations.
Implementing classes will provide methods for adding, retrieving, updating, and deleting student records.
 */

import group8.ets.Student;

import java.util.List;

public interface IStudentDatabase {
    void addStudent(Student student);
    Student getStudentByEmail(String email);
    void deleteStudentByEmail(String email);
    List<Student> getAllStudents();
}
