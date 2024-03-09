import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearchTreeExample {

    public static void main(String[] args) {
        Node root = new Node(45);
        insert(root, 70);
        insert(root, 1);
        insert(root, 17);
        insert(root, 55);
        System.out.println(search(root, 17));
        System.out.println(search(root, 66));

        List<Integer> preOrderResult = new ArrayList<>();
        List<Integer> expectedResult = Arrays.asList(45, 1, 17, 70, 55);
        preOrder(root, preOrderResult);
        System.out.println(expectedResult.toString().equals(preOrderResult.toString()));

        List<Integer> inorderResult = new ArrayList<>();
        List<Integer> expectedInOrderResult = Arrays.asList(1, 17, 45, 55, 70);
        inOrder(root, inorderResult);
        System.out.println(inorderResult.toString().equals(expectedInOrderResult.toString()));

        List<Integer> postorderResult = new ArrayList<>();
        List<Integer> expectedPostOrderResult = Arrays.asList(17, 1, 55, 70, 45);
        postOrder(root, postorderResult);
        System.out.println(postorderResult.toString().equals(expectedPostOrderResult.toString()));
    }

    static class Node {
        Integer data;
        Node left;
        Node right;

        public Node(Integer value) {
            this.data = value;
        }
    }

    static Integer search(Node tree, Integer searchKey) {
        if (tree == null) return null;
        if (searchKey == tree.data) return searchKey;
        else if (searchKey > tree.data) return search(tree.right, searchKey);
        return search(tree.left, searchKey);
    }

    static Node insert(Node tree, Integer value) {
        if(tree == null) tree = new Node(value);
        else if (value < tree.data) tree.left = insert(tree.left, value);
        else tree.right = insert(tree.right, value);
        return tree;
    }

    static void preOrder(Node tree, List<Integer> result) {
        if (tree != null) {
            result.add(tree.data);
            preOrder(tree.left, result);
            preOrder(tree.right, result);
        }
    }

    static void inOrder(Node tree, List<Integer> result) {
        if (tree != null) {
            inOrder(tree.left, result);
            result.add(tree.data);
            inOrder(tree.right, result);
        }
    }

    static void postOrder(Node tree, List<Integer> result) {
        if (tree != null) {
            postOrder(tree.left, result);
            postOrder(tree.right, result);
            result.add(tree.data);
        }
    }

    static Node delete(Node tree, Integer value) {
        if (tree == null) return null;
        if (value > tree.data) tree.right = delete(tree.right, value);
        else if (value < tree.data) tree.left = delete(tree.left, value);
        else {
            //1. no children
            //2. one child
            //3. two child
            if (tree.left == null && tree.right == null) {
                tree = null;
            } else if (tree.left == null) {
                tree = tree.right;
            } else if (tree.right == null) {
                tree = tree.left;
            } else {
                Node tmp = findBSTMinSuccessor(tree);
                tree.data = tmp.data;
                tree.right = deleteBSTMinSuccessor(tree);
            }
        }
        return tree;

    }

    static Node findBSTMinSuccessor(Node tree) {

        return null;
    }

    static Node deleteBSTMinSuccessor(Node tree) {
        return null;
    }





}
