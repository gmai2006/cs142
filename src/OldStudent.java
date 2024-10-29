public class OldStudent {
    private String lastName;
    private String firstName;
    private int age;
    private final String id;
    private String areOfStudy;
    private int yearOfCollege;

    static int numberOfStudents;


    public OldStudent(String firstName, String lastName, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        numberOfStudents++;
    }

    public OldStudent(String firstName, String lastName, String id, int age) {
        this(firstName, lastName, id);
        this.age = age;
    }

    public static OldStudent clone(OldStudent old) {
        OldStudent newStudent = new OldStudent(old.firstName, old.lastName, old.id, old.age);
        newStudent.areOfStudy = old.areOfStudy;
        newStudent.yearOfCollege = old.yearOfCollege;
        return newStudent;
    }

    public static int getNumberOfStudents() {
        return numberOfStudents;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getId() {
        return id;
    }

    public String getAreOfStudy() {
        return areOfStudy;
    }

    public int getAge() {
        return age;
    }

    public int getYearOfCollege() {
        return yearOfCollege;
    }


    @Override
    public String toString() {
        return firstName + "," + lastName + "," + id + ", " + age;
    }

}
