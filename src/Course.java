import java.util.HashMap;
import java.util.Map;

public class Course {

    static Map<Integer, String> DATETIME = new HashMap<>();

    static {
        DATETIME.put(0, "Monday");
        DATETIME.put(1, "Tuesday");
        DATETIME.put(2, "Wednesday");
        DATETIME.put(3, "Thursday");
        DATETIME.put(4, "Friday");
        DATETIME.put(5, "Saturday");
    }
    private String name;
    private int dateTime;
    private final int ID;
    private int credit;
    private String description;
    private int mode;
    private int capacity;

    public Course(int id, String name) {
        this.ID = id;
        this.name = name;
    }

    public Course(int id, String name, String descr, int mode) {
        this(id, name);
        this.description = descr;
        this.mode = mode;
    }

    public int getID() { return this.ID;}

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return this.description; }

    public void setDescription(String descr) { this.description = descr; }

    public int getMode() { return this.mode; }

    public void setMode(int mode) { this.mode = mode; }

    public int getCredit() { return this.credit; }

    public void setCredit(int credit) { this.credit = credit; }

    public int getCapacity() { return this.capacity; }

    public void setCapacity(int capacity) { this.capacity = capacity; }

    public int getDateTime() { return dateTime; }

    public void setDateTime(int dateTime) { this.dateTime = dateTime; }

    @Override
    public String toString() {
        return name + ", " + description + ", " + credit + " credit , " + DATETIME.getOrDefault(dateTime, "Wrong Date Time");
    }
}
