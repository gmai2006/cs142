import java.util.Arrays;

public class InsertionSortExample2 {
    public static void main(String[] args) {
        Integer[] test = {56,45,22,78,1,23};
        InsertionSortExample2.sort(test);
        System.out.println(Arrays.toString(test).equals("[1, 22, 23, 45, 56, 78]"));

        Integer[] empty = {};
        InsertionSortExample2.sort(empty);
        System.out.println(Arrays.toString(empty).equals("[]"));
    }

    public static void sort(Integer[] arr) {
        for (int index = 1; index < arr.length; index++) {
            for(int x = index; x > 0 && arr[x] < arr[x - 1]; x--) {
                SortUtil.swap(arr, x, x - 1);
            }
        }
    }
}
