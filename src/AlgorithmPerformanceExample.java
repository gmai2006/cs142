public class AlgorithmPerformanceExample {

    public static void main(String[] args) {
        compareUnsortedArray();
        compareSortedArray();

    }

    static void compareUnsortedArray() {
        long bubbleStartTime = System.nanoTime();
        BubbleSortExample.bubbleSort(createRandomArray(1000));
        long bubbleendTime = System.nanoTime();

        long selectionStartTime = System.nanoTime();
        SelectionSortExample.recursiveSelectionSort(createRandomArray(1000));
        long selectionendTime = System.nanoTime();

        long insertionStartTime = System.nanoTime();
        InsertionSortExample.insertSort(createRandomArray(1000));
        long insertionendTime = System.nanoTime();

        System.out.println(bubbleendTime - bubbleStartTime);
        System.out.println(selectionendTime - selectionStartTime);
        System.out.println(insertionendTime - insertionStartTime);
    }
    static void compareSortedArray() {
        int[] arr = createRandomArray(10000);
        InsertionSortExample.insertSort(arr);

        long bubbleStartTime = System.nanoTime();
        BubbleSortExample.bubbleSort(arr);
        long bubbleendTime = System.nanoTime();

        long selectionStartTime = System.nanoTime();
        BubbleSortExample.bubbleSort(arr);
        long selectionendTime = System.nanoTime();

        long insertionStartTime = System.nanoTime();
        BubbleSortExample.bubbleSort(arr);
        long insertionendTime = System.nanoTime();

        System.out.println(bubbleendTime - bubbleStartTime);
        System.out.println(selectionendTime - selectionStartTime);
        System.out.println(insertionendTime - insertionStartTime);
    }

    static int[] createRandomArray(int size) {
        int[] arr = new int[size];
        for (int index = 0; index < size; index++) {
            arr[index] = (int)(Math.random() * 100);
        }
        return arr;
    }

}
