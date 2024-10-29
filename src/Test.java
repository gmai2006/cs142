public class Test {
    public static void main(String[] args) {
        int[] anotherInts = {1, 2, 3, 3, 4};
        int result = search(anotherInts, 2);
    }

    public static int search(int[] arr, int keySearch) {
        //... your code here
        return -1;
    }
    static class Dummy {
        String name;

        public Dummy(String name) {
            this.name = name;
        }

        static Dummy copy(Dummy original) {
            return new Dummy(original.name);
        }
        @Override
        public String toString() {
            return name;
        }
    }
}


