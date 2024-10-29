public class TestDataListSolution {
    public static void main(String[] args) {
        test1();
        test2();
    }

    static void test1() {
        DataListSolution list = new DataListSolution(2);
        check("test size() ", list.size(), 0);
        check("test capacity() ", list.capacity(), 2);
        check("test add(5) ", list.add(5), 0);
        check("test report ", list.report(0), 5);
        check("test add 6 ", list.add(6), 1);
        check("test size() ", list.size(), 2);
        check("test report(1) ", list.report(1), 6);
        check("test add(7) ", list.add(7), 2);
        check("test capacity() ", list.capacity(), 4);
        check("test size() ", list.size(), 3);
        check("test report(2) ", list.report(2), 7);
        check("test report(3) ", list.report(3), null);
        check("test removeFirst(7) ", list.removeFirst(7) ? 1 : 0, 1);
        check("test size() ", list.size(), 2);
        check("test findFirst(7)", list.findFirst(7), -1);
        check("test findLast(7) ", list.findLast(7), -1);
        check("test insert(0, 7) ", list.insert(0,7) ? 1 : 0, 1);
        check("test findFirst(7) ", list.findFirst(7), 0);
        check("test findFirst(5) ", list.findFirst(5), 1);
        check("test size() ", list.size(), 3);
        check("test report(0) ", list.report(0), 7);
        check("test report(1) ", list.report(1), 5);
        check("test set(1, 9) ", list.set(1, 9), 5);
        check("test report(1) ", list.report(1), 9);
        check("test delete(7) ", list.delete(7), null);
    }

    static void test2() {
        DataListSolution list = new DataListSolution(2);
        for (int index = 0; index < 100; index++) list.add(index + 1);
        check("test size() ", list.size(), 100);
        check("test capacity() ", list.capacity(), 256);
        check("test report() ", list.report(100), null);
        check("test delete(7) ", list.delete(7), 8);
        check("test size() ", list.size(), 99);
        check("test report(98) ", list.report(98), 100);
        check("test findFirst(7) ", list.findFirst(7), 6);
        check("test findFirst(8) ", list.findFirst(8), -1);
        check("test insert(6, 300) ", list.insert(6, 300) ? 1 : 0, 1);
        check("test size() ", list.size(), 100);
        check("test report(6) ", list.report(6), 300);
        check("test add(7) ", list.add(7), 100);
        check("test removeAll(7) ", list.removeAll(7), 2);
        check("test size() ", list.size(), 99);
        check("test report(7) ", list.report(7), 9);
        check("test report(98) ", list.report(98), 100);
    }

    static void check(String descr, Integer result, Integer expected) {
        if (result == null && expected != null || (result != null && expected == null)) {
            System.out.println("FAILED " + descr + "expected " + expected + " but found " + result);
        }
        if (result != null && expected != null) {
            if (!result.equals(expected))
                System.out.println("FAILED " + descr + "expected " + expected + " but found " + result);
        }
    }
}