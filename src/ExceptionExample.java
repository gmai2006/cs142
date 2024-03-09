import java.util.Scanner;

public class ExceptionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean error = false;
        do {
            try {
                System.out.println("Please enter a number:");
                int input = getNumber(scanner.nextLine());
                System.out.println(input);
                error = false;
            } catch (NumberFormatException nfe) {
                error = true;
            }
        } while (error);
    }

    static int getNumber(String value) throws NumberFormatException {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException nfe) {
            System.err.println("Invalid input " + value);
            throw new NumberFormatException("Invalid input " + value);
        }
    }
}
