import java.util.Arrays;

public class BubbleSortExample {

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 7, -1, -3};
        bubbleSort(arr);
        System.out.println(Arrays.toString(bubbleSort(new int [] {})));
        System.out.println(Arrays.toString(bubbleSort(new int[] {1})));
        System.out.println(Arrays.toString(bubbleSort(new int[] {1, 1})));
        System.out.println(Arrays.toString(arr));

    }

    static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    static int[] bubbleSort(int[] arr) {
        boolean swapped = false;
        do {
            swapped = false;
            for (int index = 0; index < arr.length - 1; index++) {
                if (arr[index] > arr[index + 1]) {
                    swap(arr, index, index + 1);
                    swapped = true;
                }
            }
        } while (swapped);
        return arr;
    }
}
