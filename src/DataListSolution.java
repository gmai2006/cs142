import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * This is a collection class that acts like as array list for objects
 * of the Integer type.
 *
 * @author YOUR_NAME_HERE
 * @version VERSION#_&_LAST_EDIT_DATE
 */
public class DataListSolution {

    // private fields
    private Integer[] array;

    private int count = 0;

    public DataListSolution(int capacity) {
        this.array = new Integer[capacity];
    }

    /**
     * Inserts the given object at the given index.
     *
     * @param index the index where the object should be inserted
     * @param obj the object to insert
     * @return true if the insertion was successful, false if the index
     * is out of range.
     */
    boolean insert(int index, Integer obj) {
        //TODO - write this code
        resize();
        //check if the index is out of range then return FALSE
        //create a new local variable (Integer[] tmp = new Integer[count - index];
        //copy over the elements from the array to the new tmp local variable starting from the index
        //Make sure to use the correct boundary (count - index)
        //copy all elements from the tmp local variable back to the array but STARTING from the INDEX + 1
        //set the array at the given index  to the new value
        if (index >= count) return false;
        Integer[] tmp = new Integer[count - index];
        System.arraycopy(array, index, tmp, 0, count - index);
        array[index] = obj;
        System.arraycopy(tmp, 0, array, index + 1, tmp.length);
        count++;
        return true;
    }

    /**
     * Adds the given object to the end of the list (the next available place
     * in the array).
     *
     * @param obj the object to add
     * @return the index where the object was stored
     */
    int add(Integer obj) {
        //TODO - write this code
        resize();
        //set the array[count] = obj;
        //save the current count into a local variable (current)
        //current = count
        //update the count
        //return the current;
        array[count] = obj;
        int current = count;
        count = count + 1;
        return current;
    }

    /**
     * Replaces the object in the list at the given index with this object.
     *
     * @param index the location to place this object
     * @param obj the object to set at the given index
     * @return the object that was at this index before replacement
     */
    Integer set(int index, Integer obj) {
        //TODO - write this code
        //Check for the index of range first.  if yes return NULL
        int prev = array[index];
        array[index] = obj;
        return prev;
    }

    /**
     * Deletes the object at the given index from the list.
     *
     * @param index the index of the object to delete
     * @return the object deleted, or null if the index is out of range
     */
    Integer delete(int index) {
        if (index >= count) return null;
        //TODO - write this code
        //move all the elements STARTING index + 1 to the left one position by using the for-loop
        //make sure to use the correct boundary
        //inside the for-loop starting from the index
        //set the array at the index = array at the index + 1
        int curr = array[index];
        for (int x = index; x < count; x++) {
            array[x] = array[x + 1];
        }
        count--;
        resize();
        return curr;
    }

    /**
     * Removes the first instance of this object from the list.
     *
     * @param obj the object to match for removal
     * @return true if removed, false if the object is not in the list
     */
    boolean removeFirst(Integer obj) {
        //TODO - write this code
        int index = findFirst(obj);
        if (index == -1) return false;
        delete(index);
        resize();
        return true; // or true
    }

    /**
     * Removes all instances of this object from the list.
     *
     * @param obj the object to match for removal
     * @return the number of objects removed
     */
    int removeAll(Integer obj) {
        //TODO - write this code
        int index = -1;
        int removed = 0;
        while ((index = findFirst(obj)) != -1) {
            if (removeFirst(obj)) removed++;
        }
        return removed; // replace it with the l
    }

    /**
     * Reports the object in the list at the given index.
     *
     * @param index the index of the object to return
     * @return the object at the given index, or null if the index is out of
     * range.
     */
    Integer report(int index) {
        //TODO - write this code
        //Check for the index of range first.  if yes return NULL
        if (index >= count) return null;
        return array[index]; // return the value of the given index (using index notation)
    }

    /**
     * Finds the first instance of the given object.
     *
     * @param obj the object to find
     * @return the index where the object was found, or -1 if not found.
     */
    int findFirst(Integer obj) {
        //TODO - write this code
        //using for-loop to iterate through the data list (count) starting from the first element
        //if found return the current index.  Otherwise, return -1
        return IntStream.range(0, count).filter(x -> array[x] == obj).findFirst().orElse(-1);
    }

    /**
     * Finds the last instance of the given object.
     *
     * @param obj the object to fine
     * @return the index where the object was found, or -1 if not found.
     */
    int findLast(Integer obj) {
        //TODO - Write this code
        //using for-loop to iterate through the data list (count) starting from the last element
        //if found return the current index.  Otherwise, return -1
        return IntStream.range(0, count).filter(x -> array[count - x] == obj).findFirst().orElse(-1);
    }

    /**
     * Reports the number of elements currently stored in the list.
     *
     * @return the number of elements
     */
    int size() {
        return count;
    }

    /**
     * Reports the current size of the underlying array.
     *
     * @return the size of the array
     */
    int capacity() {
        return array.length;
    }

    /**
     * Returns a String representation of the list of objects currently stored
     * in the list.
     *
     * @return the string representation of the list
     */
    @Override
    public String toString() {
        String str = "[";
        for (Integer obj : array) {
            str += obj.toString() + ",";
        }
        if (array.length > 0) {
            str = str.substring(0, str.length() - 1);
        }
        str += "]";
        return str;
    }

    /**
     YOU MUST UPDATE THIS FUNCTION
     * Doubles the size of the array and copies the current elements into the
     * new, larger array.
     * Use System.arraycopy();
     */
    private void resize() {
        if (count >= .75 * array.length) {
            //double the size of the internal array
            //create a local Integer[] called tmp
            Integer[] tmp = new Integer[array.length * 2];
            //copy over the existing elements from the array to tmp variable
            // your code is here
            //set array to tmp
            System.arraycopy(array, 0, tmp, 0, array.length);
            array = tmp;

        } else if (count <= 0.25 * array.length) {
            //shrink the size of the internal array by half
            //create a local Integer[] called tmp
            Integer[] tmp = new Integer[array.length / 2];
            //copy over the existing elements from the array to tmp variable
            // your code is here
            //set array to tmp
            System.arraycopy(array, 0, tmp, 0, tmp.length);
            array = tmp;
        }
    }
}