import java.util.Scanner;
public class QuizTree {
    QuizTreeNode root;

    public QuizTree(Scanner inputFile) {
        root = read(inputFile, root);
    }

    private QuizTreeNode read(Scanner input, QuizTreeNode node) {
//        if (!input.hasNext())
//            return node;
//        String line = input.nextLine();
        /** DONE
         * 1. set node to a new node
         * 2. check if the line is the leaf => return the node
         * 3. otherwise, set node left = read (input, node left)
         * set node right = read(input, node right)
         * return node
         */

        String line = input.nextLine();
        node = new QuizTreeNode(line); // 1. set node to a new node
        if (line.startsWith("END:")) return node; // 2. check if the line is the leaf => return the node
        node.left = read(input, node.left); // 3. set node left = read (input, node left)
        node.right = read(input, node.right); // set node right = read(input, node right)
        return node;
    }

    public void takeQuiz(Scanner console) {
        takeQuiz(console, root);
    }

    private void takeQuiz(Scanner console, QuizTreeNode node) {
        /**
         * if the node is a leaf (both children are null) => display the value and
         return
         * Split the node value into two values (e.g. blue and green)
         * prompt the user using nodes' value
         * get the response from the user and determine is that left or right
         * if the response equals left call takeQuiz(console, node.left)
         * else if the response equals right call takeQuiz (console, node.right)
         * else prompt the user 'Invalid response; try again.'
         */
        if (node.isLeaf()) { // if the node is a leaf (both children are null) => display the value and return
            System.out.println(node.value);
            return;
        }
        // Split the node value into two values (e.g. blue and green)
        // Implement the split logic here
        // prompt the user using nodes' value
        System.out.println(node.value);
        System.out.print("Enter your choice (left/right): ");
        String response = console.nextLine().trim().toLowerCase();
        if (response.equals("left")) takeQuiz(console, node.left);
        else if (response.equals("right")) takeQuiz(console, node.right);
        else {
            // else prompt the user 'Invalid response; try again.'
            System.out.println("Invalid response; try again.");
            takeQuiz(console, node);
        }
    }
    public void export() {
        export(root);
    }

    private void export(QuizTreeNode node) {
        /** DONE
         * display the bst data to the console using System.out.println()
         * if node is null return
         * if node is a leaf print "END:" + leaf value
         * else print leaf value
         * call export(node left)
         * call export(node right)
         */
        if (node == null) return;

        System.out.println(node.value);

        if (node.isLeaf()) {
            System.out.println("END:" + node.value);
        }

        export(node.left);
        export(node.right);
    }

    public void addQuestion(String toReplace, String leftChoice, String
            rightChoice, String leftResult, String rightResult) {
        /**DONE
         * 1. use the search function to search for the item
         * 2. Concat the left choice and right choice into a single new value
         * 3. update the node value (toReplace) with the new value
         * 4. Add a left node with information from the leftResult
         * 5. Add a right node with the information from the rightResult
         */
        // Step 1: Use the search function to find the node with the specified value
        QuizTreeNode targetNode = search(toReplace, root);

        // Step 2: Concatenate left and right choices into a single new value
        String newValue = leftChoice + "/" + rightChoice;

        // Step 3: Update the node value (toReplace) with the new value
        if (targetNode != null) {
            targetNode.value = newValue;

            // Step 4: Add a left node with information from leftResult
            targetNode.left = new QuizTreeNode(leftResult);

            // Step 5: Add a right node with information from rightResult
            targetNode.right = new QuizTreeNode(rightResult);
        } else {
            System.out.println("Node with value '" + toReplace + "' not found.");
        }
    }

    public QuizTreeNode search(String value) {
        return search(value, root);
    }

    private QuizTreeNode search(String value, QuizTreeNode node) {
        /** DONE
         * if (node is null ) return null;
         * if (node value is the same as the value)
         * node.left = call itself (value, node.left)
         * node.right = call itself (value, node.right);
         */
        if (node == null) return null;

        if (node.value.equals(value)) {
            return node;
        }

        QuizTreeNode leftResult = search(value, node.left);
        if (leftResult != null) return leftResult;

        QuizTreeNode rightResult = search(value, node.right);
        return rightResult;
    }

    static class QuizTreeNode {
        public String value;
        QuizTreeNode left;
        QuizTreeNode right;

        public QuizTreeNode(String value) {
            if (value.startsWith("END:")) {
                value = value.substring("END:".length());
            }
            this.value = value;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

        @Override
        public String toString() {
            return "QuizTreeNode{" +
                    "value='" + value + '\'' +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}