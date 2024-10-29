import java.util.Arrays;

public class QuickSortExample2 {
    public static void main(String[] args) {
        Integer[] test = {56,45,22,78,1,23};
        QuickSortExample2.sort(test);
        System.out.println(Arrays.toString(test).equals("[1, 22, 23, 45, 56, 78]"));

        Integer[] empty = {};
        QuickSortExample2.sort(empty);
        System.out.println(Arrays.toString(empty).equals("[]"));
    }

    public static void sort(Integer[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(Integer[] arr, int low, int hi) {
        if (low < hi) {
            int p = partition(arr, low, hi);
            sort(arr, low, p - 1);
            sort(arr, p + 1, hi);
        }
    }

    private static int partition(Integer[] arr, int low, int hi) {
        int storedIndex = low + 1;
        for (int x = low + 1; x <= hi; x++) {
            if (arr[x] < arr[low]) {
                SortUtil.swap(arr, x, storedIndex);
                storedIndex++;
            }
        }
        SortUtil.swap(arr,storedIndex - 1, low);
        return storedIndex - 1;
    }
}
