import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecursiveExample {
    public static void main (String[] args) {
//        System.out.println(factorialIterative(5));
//        System.out.println(factorialRecursive(5));
//        System.out.println(reciprocalPowerOfTwoIterative(32));
//        System.out.println(reciprocalPowerOfTwo(32));
//
//        List<String> list = Arrays.asList("test1", "hello", "nemo", "john", "jane");
        printDirectory(new File("./"));
    }

    static double factorialIterative(int x) {
        int total = 1;
        for (int index = x; index >= 1; index--) {
            total = total * index;
        }
        return total;
    }

    static double factorialRecursive(int x) {
        if (x == 1) return 1;
        return x * factorialRecursive(x - 1);
    }

    static double reciprocalPowerOfTwo(int x) {
        if (x == 1) return 1;
        return 1./x + reciprocalPowerOfTwo(x/2);
    }

    static double reciprocalPowerOfTwoIterative(int x) {
        double sum = 1;
        for (int index = x; index > 1; index = index / 2) {
            sum = sum + 1./index;
        }
        return sum;
    }

    static int linearSearch(List<String> list, String searchKey) {
        int index = 0;
        for (String item : list) {
            if (item.equals(searchKey)) return index;
            index++;
        }
        return -1;
    }

    static void printDirectory(File item) {
        if (item.isFile()) {
            System.out.println(item.getName());
        } else {
            for (File child : item.listFiles()) {
                printDirectory(child);
            }
        }
    }
}

