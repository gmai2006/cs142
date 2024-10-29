public class SortUtil {
    public static void swap(Integer[] arr, int sourceIndex, int sinkIndex) {
        int tmp = arr[sourceIndex];
        arr[sourceIndex] = arr[sinkIndex];
        arr[sinkIndex] =  tmp;
    }
}
