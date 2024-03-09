import java.util.Arrays;

public class MergeSortExample {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(sort(new int [] {})));
        System.out.println(Arrays.toString(sort(new int[] {1})));
        System.out.println(Arrays.toString(sort(new int[] {1, 1})));
        int[] arr = {1,3,4,7,-3,-9};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static int[] sort(int[] arr) {
        if (arr.length <= 1) return arr;
        int[] left = new int[arr.length/2];
        int[] right = new int[arr.length - left.length];
        System.arraycopy(arr, 0, left, 0, left.length);
        System.arraycopy(arr, arr.length/2, right, 0, right.length);
        sort(left);
        sort(right);
        merge(arr, left, right);
        return arr;
    }

    static void merge(int[] arr, int[] left, int[] right) {
        int ileft = 0;
        int iright = 0;

        for (int index = 0; index < arr.length; index++) {
            if (iright >= right.length || (ileft < left.length && left[ileft] < right[iright])) {
                arr[index] = left[ileft++];
            } else {
                arr[index] = right[iright++];
            }
        }
    }
}
