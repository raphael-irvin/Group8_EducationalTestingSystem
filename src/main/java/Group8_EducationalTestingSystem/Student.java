package Group8_EducationalTestingSystem;

/*
CLASS INFORMATION:
The Group8_EducationalTestingSystem.Student (User) class is the primary class used for user sessions and to store respective data of the user
 */

public class Student {

    // ATTRIBUTES
    // Personal Information
    private String name;
    private String email;

    // Score and Performance Data
    // TODO: (Attributes related to scores and performance can be added here)

    //Default Constructor
    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
