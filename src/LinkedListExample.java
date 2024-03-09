public class LinkedListExample {

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            next = null;
        }
    }

    static class LinkedList {
        Node root;
        int size = 0;
        public int add(int value, int index) {
            if (index >= size) return - 1;
            //1. iterate the list starting from the beginning to index
            int localIndex = 0;
            Node tmp = root;
            Node prev = root;

            while (localIndex < index) {
                prev = tmp;
                tmp = tmp.next;
            }

            Node newNode = new Node(value);
            prev.next = newNode;
            newNode.next = tmp;
            return prev.value;
        }

    }
}
