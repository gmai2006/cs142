import java.util.Arrays;

public class SelectionSortExample {
    public static void main(String[] args) {
        int[] arr = {1,3,4,7};
        iterativeSelectionSort(arr);
        System.out.println(Arrays.toString(iterativeSelectionSort(new int [] {})));
        System.out.println(Arrays.toString(iterativeSelectionSort(new int[] {1})));
        System.out.println(Arrays.toString(iterativeSelectionSort(new int[] {1, 1})));
        System.out.println(Arrays.toString(arr));

        System.out.println(Arrays.toString(iterativeSelectionSort2(new int [] {})));
        System.out.println(Arrays.toString(iterativeSelectionSort2(new int[] {1})));
        System.out.println(Arrays.toString(iterativeSelectionSort2(new int[] {1, 1})));
        System.out.println(Arrays.toString(arr));

        System.out.println(Arrays.toString(recursiveSelectionSort(new int [] {})));
        System.out.println(Arrays.toString(recursiveSelectionSort(new int[] {1})));
        System.out.println(Arrays.toString(recursiveSelectionSort(new int[] {1, 1})));
        System.out.println(Arrays.toString(arr));
    }

    static int[] recursiveSelectionSort(int[] arr) {
        return recursiveSelectionSortInternal(arr, 0, arr.length - 1);
    }

    static private int[] recursiveSelectionSortInternal(int[] arr, int start, int end) {
        if (start >= end) return arr;
        //1. find the min index
        //2. swap with the element at the start index
        //3. call itself again with the start = start + 1
        int minIndex = findMinIndex(arr, start);
        swap(arr, start, minIndex);
        return recursiveSelectionSortInternal(arr, start + 1, end);
    }
    static int[] iterativeSelectionSort(int[] arr) {
        for (int index = 0; index < arr.length; index++) {
            int minIndex = findMinIndex(arr, index);
            swap(arr, minIndex, index);
        }
        return arr;
    }

    static int[] iterativeSelectionSort2(int[] arr) {
        for (int index = 0; index < arr.length; index++) {
            int min = arr[index];
            int minIndex = index;
            for (int innerIndex = index; innerIndex < arr.length; innerIndex++) {
                if (arr[innerIndex] < min) {
                    min = arr[innerIndex];
                    minIndex = innerIndex;
                }
            }
            swap(arr, index, minIndex);
        }
        return arr;
    }

    static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    static int findMinIndex(int[] arr, int start) {
        int min = arr[start];
        int minIndex = start;
        for (int index = start + 1; index < arr.length; index++) {
            if (arr[index] < min) {
                min = arr[index];
                minIndex = index;
            }
        }
        return minIndex;
    }
}
