import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestClient {
    public static void main(String[] args) {
        Course java = new Course(1, "Java");
        java.setDescription("This is Java class CS 142");
        java.setDateTime(8);
        java.setCredit(5);

        Course python = new Course(1, "Python");
        python.setDescription("This is CS 115");
        python.setDateTime(9);
        python.setCredit(5);

        Student student = new Student(1, "John", "Deer");
        student.addClass(java);
        student.addClass(python);

        List<Student> searchResult = searchByClassName(Arrays.asList(student), "jAva");
        System.out.println(searchResult);

        List<Student> emptyResult = searchByClassName(Arrays.asList(student), "Math");
        System.out.println(emptyResult);
    }

    public static List<Student> searchByClassName(List<Student> students, String search) {
        List<Student> result = new ArrayList<>();

        for (Student student : students) {
            for(Course course : student.getCourses()) {
                if (course.getName().equalsIgnoreCase(search)) {
                    result.add(student);
                }
            }
        }
        return result;
    }
}
