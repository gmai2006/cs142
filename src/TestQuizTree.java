import java.io.*;
import java.util.Scanner;

public class TestQuizTree {
    public static void main(String[] args) throws FileNotFoundException {
        File inFile = new File("./colors-cereals.txt");
        QuizTree quiz = new QuizTree(new Scanner(inFile));
        check(quiz.root);
        quiz.addQuestion("Froot Loops", "gold", "silver", "Cheerios", "Frosted Mini-Wheats");
        check2(quiz.root);
    }

    static void check(QuizTree.QuizTreeNode node) {
        check(node.value, "red/blue", "Test reading data.");
        check(node.left.value, "yellow/green", "Test reading data.");
        check(node.right.value, "purple/orange", "Test reading data.");
        check(node.left.left.value, "Froot Loops", "Test reading data.");
        check(node.left.right.value, "Raisin Bran", "Test reading data.");

        check(node.right.left.value, "Frosted Flakes", "Test reading data.");
        check(node.right.right.value, "black/white", "Test reading data.");
        check(node.right.right.left.value, "Rice Krispies", "Test reading data.");
        check(node.right.right.right.value, "Fruity Pebbles", "Test reading data.");
    }

    static void check2(QuizTree.QuizTreeNode node) {
        check(node.value, "red/blue", "Test reading data.");
        check(node.left.value, "yellow/green", "Test reading data.");
        check(node.right.value, "purple/orange", "Test reading data.");
        check(node.left.left.value, "gold/silver", "Test reading data.");
        check(node.left.left.left.value, "Cheerios", "Test reading data.");
        check(node.left.left.right.value, "Frosted Mini-Wheats", "Test reading data.");
        check(node.left.right.value, "Raisin Bran", "Test reading data.");

        check(node.right.left.value, "Frosted Flakes", "Test reading data.");
        check(node.right.right.value, "black/white", "Test reading data.");
        check(node.right.right.left.value, "Rice Krispies", "Test reading data.");
        check(node.right.right.right.value, "Fruity Pebbles", "Test reading data.");
    }

    static void check(String result, String expected, String descr) {
        if (!result.equals(expected))
            System.out.println("FAILED " + descr + " expected " + expected + " but found " + result);
    }
}
