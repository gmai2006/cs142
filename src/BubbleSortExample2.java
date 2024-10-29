import java.util.Arrays;
import java.util.List;

public class BubbleSortExample2 {
    public static void main(String[] args) {
        Integer[] test = {56,45,22,78,1,23};
        BubbleSortExample2.sort(test);
        System.out.println(Arrays.toString(test).equals("[1, 22, 23, 45, 56, 78]"));

//        Integer[] empty = {};
//        BubbleSortExample2.sort(empty);
//        System.out.println(empty.toString().equals(""));

    }

    /**
     * Start at the first index and compare the value with the one right after it.
     * ◦
     * If the first one is larger, swap the two and move to the larger one.
     * ◦
     * If not, just move to the second index.
     * ◦
     * Compare this value with the one right after it.
     * ◦
     * Continue until you reach the end.
     * ◦
     * Go back to the beginning and do it again.
     * ◦
     * Keep repeating until no more swaps are possible.
     */

    public static void sort(Integer[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        boolean isSwapped = true;
        while (isSwapped) {
            isSwapped = false;
            for (int index = 0; index < arr.length - 1; index++) {
                if (arr[index] > arr[index + 1]) {
                    swap(arr, index, index + 1);
                    isSwapped = true;
                }
            }
        }
    }


    public static void swap(Integer[] arr, int sourceIndex, int sinkIndex) {
        int tmp = arr[sourceIndex];
        arr[sourceIndex] = arr[sinkIndex];
        arr[sinkIndex] =  tmp;
    }
}
