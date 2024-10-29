class InternalNode {
    Item value;
    InternalNode next;

    public InternalNode(Item value) {
        this.value = value;
    }
}

public class ItemList {

    //field
    private InternalNode first;
    private int count;

    public boolean insert(int index, Item item) {
        //TODO write this method
        if (index < 0 || index > count)
            return false;
        if (index == 0) {
            InternalNode newNode = new InternalNode(item);
            newNode.next = first;
            first = newNode;
            count++;
            return true;
        }
        InternalNode current = first;
        for (int i = 0; i < index - 1; i++){
            current = current.next;
        }
        InternalNode newNode = new InternalNode(item);
        newNode.next = current.next;
        current.next = newNode;
        count++;
        return true;
    }

    public boolean add(Item item) {
        //TODO write this method
        return insert(0, item);
    }

    public Item set(int index, Item item) {
        //TODO write this method
        if (index < 0 || index >= count)
            return null;
        InternalNode current = first;
        for (int i = 0; i < index; i++){
            current = current.next;
        }
        Item oldValue = current.value;
        current.value = item;
        return oldValue;
    }

    public Item delete(int index) {
        //TODO write this method
        if (index < 0 || index >= count)
            return null;
        if (index == 0){
            Item oldValue = first.value;
            first = first.next;
            count--;
            return oldValue;
        }
        InternalNode current = first;
        for (int i = 0; i < index - 1; i++){
            current = current.next;
        }
        Item oldValue = current.next.value;
        current.next = current.next.next;
        count--;
        return oldValue;
    }

    public boolean remove(Item item) {
        int index = find(item);
        if (index < 0) return false;
        Item temp = delete(index);
        if(temp!=null)
            return true;
        return false; //TODO replace this return statement
    }

    public Item report(int index) {
        //TODO write this method
        if (index < 0 || index >= count)
            return null;
        InternalNode current = first;
        for (int i = 0; i < index; i++){
            current = current.next;
        }
        return current.value;
    }

    public int find(Item item) {
        /**
         * a. set the current node = root
         * b. iternte until either find the node or return -1
         */
        //TODO write this method
        InternalNode current = first;
        for (int i = 0; i < count; i++){
            if (current.value.equals(item))
                return i;
            current = current.next;
        }
        return -1; //TODO replace this return statement
    }

    public int size() {
        return count;
    }

    @Override
    public String toString() {
        //TODO write this method
        String result = "";
        InternalNode current = first;
        for (int i = 0; i < count; i++){
            result += current.value.toString() + "\n";
            current = current.next;
        }
        return result;
    }

    public double getTotalCost() {
        double totalCost = 0.;
        //iterate through the list and sum all the cost
        InternalNode current = first;
        for (int i = 0; i < count; i++){
            totalCost += current.value.getCost();
            current = current.next;
        }
        return totalCost;
    }

    public double getTotalValue() {
        double totalPrice = 0.;
        //TODO write this method
        InternalNode current = first;
        for (int i = 0; i < count; i++){
            totalPrice += current.value.calcPrice();
            current = current.next;
        }
        return totalPrice;
    }

}



