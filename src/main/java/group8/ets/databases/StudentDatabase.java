package group8.ets.databases;

/*
CLASS INFORMATION:
The StudentDatabase class is responsible for managing the storage and retrieval of Student objects within the Educational Testing System.
It provides methods to add, remove, update, and query student records, ensuring efficient access to student data for various operations such as authentication, profile management, and performance tracking.
It is singleton in nature, ensuring that only one instance of StudentDatabase exists throughout the application lifecycle.
 */

import group8.ets.Student;
import group8.ets.Utility;

import java.util.HashMap;
import java.util.List;

public class StudentDatabase implements IStudentDatabase{

    private HashMap<String, Student> studentMap = new HashMap<>();

    // Singleton Instance
    private static StudentDatabase instance = null;

    // Private Constructor to prevent instantiation
    private StudentDatabase() {
    }

    // Method to get the Singleton Instance
    public static StudentDatabase getInstance() {
        if (instance == null) {
            instance = new StudentDatabase();
        }
        return instance;
    }

    @Override
    public void addStudent(Student student) {
        studentMap.put(student.getEmail(), student);
        Utility.log("Student Stored: " + student.getEmail());
    }

    @Override
    public Student getStudentByEmail(String email) {
        return studentMap.get(email);
    }

    @Override
    public void deleteStudentByEmail(String email) {
        studentMap.remove(email);
    }

    @Override
    public List<Student> getAllStudents() {
        return List.copyOf(studentMap.values());
    }
}
