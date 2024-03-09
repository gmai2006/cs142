import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class ExceptionWithResourceExample {
    public static void main(String[] args) {
        testFinallyClause();
        testTryWithResource();

    }

    static void testFinallyClause() {
        InputStream in = null;
        try {
            in = new FileInputStream("mytest.txt");
            Scanner scanner = new Scanner(in);
        } catch (FileNotFoundException fne) {
            System.err.println("mytest.txt is NOT FOUND");
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ioe) {
                    //ignore
                }
            } else {
                System.out.println("The inputstream is null");
            }
        }
    }

    static void testTryWithResource() {
        try (InputStream in = new FileInputStream("mytest.txt")) {

        } catch (FileNotFoundException fne) {
            System.out.println(fne);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
}
