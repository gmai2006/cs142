public class TestItemList {
    public static void main(String[] args) {
        test();
    }

    static void test() {
        ItemList list = new ItemList();
        list.add(new SpecialtyItem1(1, "test", 10.));
        list.add(new SpecialtyItem2(2, "test2", 1.));
        check("test size", list.size(), 2);
        check("test report", list.report(0),  new SpecialtyItem2(2, "test2", 1.));
        check("test report", list.report(1),  new SpecialtyItem1(1, "test", 10.));
        check("test report", list.report(2),  null);
        check("test getTotalCost", list.getTotalCost(), 11.);
        check("test getTotalValue", list.getTotalValue(), 22.);
        check("test find", list.find(new SpecialtyItem1(1, "test", 10.)), 1.);
        check("test find", list.find(new SpecialtyItem1(4, "test3", 10.)), -1.);
        check("test remove", list.remove(new SpecialtyItem1(4, "test3", 10.)), false);
        check("test remove", list.remove(new SpecialtyItem1(1, "test", 10.)), true);
        check("test size", list.size(), 1);
        check("test set", list.set(0, new SpecialtyItem1(4, "test3", 10.)), new SpecialtyItem2(2, "test2", 1.));
        check("test insert", list.insert(0, new SpecialtyItem1(7, "test4", 10.)), true);
        check("test size", list.size(), 2);
        check("test find", list.find(new SpecialtyItem1(7, "test4", 10.)), 0.);
    }

    static void check(String descr, boolean result, boolean expected) {
        if (result != expected)
            System.out.println("FAILED " + descr + " expected " + expected + " but found " + result);
    }

    static void check(String descr, Integer result, Integer expected) {
        if (!result.equals(expected))
            System.out.println("FAILED " + descr + " expected " + expected + " but found " + result);
    }

    static void check(String descr, double result, double expected) {
        if (result != expected)
            System.out.println("FAILED " + descr + " expected " + expected + " but found " + result);
    }

    static void check(String descr, Item result, Item expected) {
        if (result == null && expected == null) return;
        if (result == null && expected != null || (result != null && expected == null)) {
            System.out.println("FAILED " + descr + "expected " + expected + " but found " + result);
            return;
        }

        if (!result.equals(expected))
            System.out.println("FAILED " + descr + " expected " + expected + " but found " + result);

    }
}