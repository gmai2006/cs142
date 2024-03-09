import java.util.Arrays;

public class CoutingSortExample {
    public static void main(String[] args) {

//        System.out.println(Arrays.toString(sort(new int [] {})));
//        System.out.println(Arrays.toString(sort(new int[] {1})));
//        System.out.println(Arrays.toString(sort(new int[] {1, 1})));
        int[] arr = {1,3,4,7,3,9};
        sort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    static int[] sort(int[] arr) {
        int[] count = new int[10 + 1];
        int[] aux = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i] + 1]++;
        }
        for (int r = 0; r < 10; r++) {
            count[r + 1] += count[r];
        }
        for (int i = 0; i < arr.length; i++) {
            aux[count[arr[i]]++] = arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = aux[i];
        }
        return arr;
    }

    static int[] sort2(int[] arr) {
        int[] count = new int[10];
        int[] index = new int[10];
        int[] aux = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        for (int r = 0; r < 10; r++) {
            if (r > 0) {
                index[r] = index[r-1] + count[r];
            }else {
                index[r] = count[r];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            aux[index[arr[i]]++] = arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = aux[i];
        }
        return arr;
    }

}
