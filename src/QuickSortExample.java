import java.util.Arrays;

public class QuickSortExample {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(sort(new int [] {})));
        System.out.println(Arrays.toString(sort(new int[] {1})));
        System.out.println(Arrays.toString(sort(new int[] {1, 1})));
        int[] arr = {1,3,4,7,-3,-9};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static int[] sort(int[] arr) {
        return sort(arr, 0, arr.length - 1);
    }

    private static int[] sort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int pivot = partition(arr, lo, hi);
            sort(arr, 0, pivot - 1);
            sort(arr, pivot + 1, hi);
        }
        return arr;
    }

    private static int partition(int[] arr, int lo, int hi) {
        int pivot = arr[hi];
        int i = lo - 1;
        for (int j = lo; j < hi; j++) {
            if (arr[j] <= pivot) {
                i = i + 1;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, hi);
        return i + 1;
    }

    static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
}
