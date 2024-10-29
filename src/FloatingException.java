import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FloatingException {
    public static void main (String[] args) {
        Object first = new Dummy("test1");
        Dummy two = (Dummy)first;
        System.out.println(two);
//        first.list.add("5");
//        System.out.println(two);
    }



    static class Dummy {

        public Dummy(String name) { this.name = name; }
        String name;

        ArrayList<String> list = new ArrayList<>(Arrays.asList("1", "2", "4"));

        @Override
        public String toString() {
            return name + list.toString();
        }
    }
}
