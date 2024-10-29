import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Student {
    private final int STUDENT_ID;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    private List<Course> classes;

    public Student(int studentId, String firstName, String lastName) {
        this.STUDENT_ID = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        classes = new ArrayList<>();
    }

    public List<Course> getCourses() { return classes; }

    public void addClass(Course c) {
        this.classes.add(c);
    }
    public int getStudentId() { return STUDENT_ID; }

    public String getEmail() { return email; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return firstName + ", " + lastName + ", " + classes;
    }
}
