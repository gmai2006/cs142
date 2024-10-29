import java.util.Arrays;

public class ArrayPractice {
    public static void main(String[] args) {
        int[] arr = generateRandomArray(10);
        updateArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Use Math.random or Random
     * @param size
     * @return
     */
    static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for (int x = 0; x < size; x++) {
            arr[x] = (int)(Math.random() * (size + 10));
        }
        return arr; //
    }

    static void updateArray(int[] arr) {
        int max = Math.max(arr[0], arr[arr.length - 1]);
        arr[0] = max;
        arr[arr.length - 1] = max;
    }
}
