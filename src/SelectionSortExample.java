import java.util.Arrays;
import java.util.List;

public class SelectionSortExample {
    public static void main(String[] args) {
        List<Integer> test = Arrays.asList(56,45,22,78,1,23);
        SelectionSortExample.sort(test);
        System.out.println(test.toString().equals(Arrays.asList(1,22,23,45,56,78).toString()));

        List<Integer> empty = Arrays.asList();
        SelectionSortExample.sort(empty);
        System.out.println(empty.toString().equals("[]"));

        List<Integer> test2 = Arrays.asList(56,45,22,78,1,23);
        SelectionSortExample.sortRecursive(test2);
        System.out.println(test2.toString().equals(test.toString()));

    }

    /**
     * Find the smallest value in the array
     * ◦
     * Swap it with the first element
     * ◦
     * Find the next smallest value in the array
     * ◦
     * Swap it with the second element
     * @param list
     *
     * [1,4,5,6]
     */
    public static void sort(List<Integer> list) {
        for (int x = 0; x < list.size(); x++) {
            int smallestIndex = findSmallestValueIndex(list, x);
            swap(list, x, smallestIndex);
        }
    }

    public static void sortRecursive(List<Integer> list) {
        sortRecursive(list, 0);
    }

    private static void sortRecursive(List<Integer> list, int index) {
        if (list.size() <= 1 || index >= list.size()) return;
        int smallestIndex = findSmallestValueIndex(list, index);
        swap(list, index, smallestIndex);
        sortRecursive(list, index + 1);
    }

    private static void swap(List<Integer> list, int sourceIndex, int sinkIndex) {
        int tmp = list.get(sourceIndex);
        list.set(sourceIndex, list.get(sinkIndex));
        list.set(sinkIndex, tmp);
    }
    private static int findSmallestValueIndex(List<Integer> list, int startingIndex) {
        Integer smallest = Integer.MAX_VALUE;
        int index = 0;
        for (int x = startingIndex; x < list.size(); x++) {
            if (list.get(x) < smallest) {
                smallest = list.get(x);
                index = x;
            }
        }
        return index;
    }
}
