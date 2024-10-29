import java.io.File;
import javax.swing.JInternalFrame;

public class RecursiveExample2 {
    public static void main(String[] args) {
//        System.out.println(isPalindrome("repaper") == isPalindromeRecusrive("repaper"));
//        System.out.println(isPalindrome("") == isPalindromeRecusrive(""));
//        System.out.println(isPalindrome("moon") == isPalindromeRecusrive("moon"));
//        displayFileFolder(new File("./"));
        System.out.println(powerOf2Convergent(20) == powerOf2ConvergentRecursive(20));
    }

    public static int fibonacci(int value) {
        if (value == 0) return 0;
        if (value == 1) return 1;
        return fibonacci(value - 1) + fibonacci(value - 2);
    }

    static boolean isPalindrome(String value) {
        for (int left = 0, right = value.length() - 1; left < right; left++, right--) {
            if (value.charAt(left) != value.charAt(right)) return false;
        }
        return true;
    }


    static boolean isPalindromeRecusrive(String value) {
        if (value.length() == 0 || value.length() == 1) return true;
        return (value.charAt(0) == value.charAt(value.length() - 1))
                && isPalindromeRecusrive(value.substring(1, value.length() - 1));
    }

    static void displayFileFolder(File object) {
        if (object == null) return;

        if (object.isFile()) {
            System.out.println(object.getAbsolutePath());
            return;
        }

        File[] children = object.listFiles();
        for (File child : children) {
            displayFileFolder(child);
        }
    }

    static double powerOf2Convergent(int iterations) {
        double result = 1;
        for (int x = 1; x <= iterations; x++) {

            result += 1/Math.pow(2, x) ;
        }
        return result;
    }

    static double powerOf2ConvergentRecursive(int interations) {
        if (interations == 0) return 1;
        return 1 / Math.pow(2, interations) + powerOf2ConvergentRecursive(interations - 1);
    }
}
