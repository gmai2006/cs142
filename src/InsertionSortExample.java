import java.util.Arrays;

public class InsertionSortExample {

    public static void main(String[] args) {
        int[] arr = {1,3,4,7,-3,-9};
        insertSort(arr);
        System.out.println(Arrays.toString(insertSort(new int [] {})));
        System.out.println(Arrays.toString(insertSort(new int[] {1})));
        System.out.println(Arrays.toString(insertSort(new int[] {1, 1})));
        System.out.println(Arrays.toString(arr));
    }

    static int[] insertSort(int[] arr) {
        for (int index = 1; index < arr.length; index++) {
            int pos = index;
            while (pos > 0 && arr[pos - 1] > arr[pos]) {
                swap(arr, pos - 1, pos);
                pos -= 1;
            }
        }
        return arr;
    }

    static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
}
