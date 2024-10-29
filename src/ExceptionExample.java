import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionExample {
    public static void main(String[] args) {
        int result = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            while ((result = readInputFromConsole(scanner)) != 0) {
                System.out.println(result);
            }
        }
    }

    public static int readInputFromConsole(Scanner scanner) {
        int number = 0;
        System.out.println("Enter a number:");
        do {
            try {
                number = readInput(scanner);
            } catch (NumberFormatException ex) {
                number = -1;
            }
        } while (number == -1);
        return number;
    }

    public static int readInput(Scanner scanner) throws NumberFormatException {
        String input = "";
        try {
            input = scanner.nextLine();
        }  catch (NumberFormatException ex) {
            System.out.println("Invalid input: " + input + " Please enter a number");
            throw ex;
        }
        return Integer.valueOf(input);
    }
}
