public class TestSortableSet {
    public static void main(String[] args) {
        test1();
    }

    static void test1() {
        SortableSet set = new SortableSet();
        try {
            set.add(new SortableItem(1, "test"));
            set.add(new SortableItem(33, "test3"));
            set.add(new SortableItem(22, "test2"));
            set.add(new SortableItem(4, "test4"));
            long[] keys = set.getKeys();
            check("add 1", keys[0], 1L);
            check("add 33", keys[2], 22L);
            check("add 4", keys[keys.length - 1], 4L);

        } catch (DuplicateException e) {
            System.out.println("Test add failed due to duplication");
        }

        try {
            set.add(new SortableItem(1, "test"));
            System.out.println("test add duplicate FAILED");
        } catch (DuplicateException e) {
            //must go here => pass the test
        }

        Sortable[] sortables = set.getSortedList();
        check("test sort", sortables[1].getSortKey(), 4L);

        //test get key
        try {
            set.get(55);
            System.out.println("test get FAILED");
        } catch (InvalidKeyException e) {
            //must go here => pass the test
        }

        //test update
        try {
            set.update(new SortableItem(1, "testupdate"));
        } catch (InvalidKeyException  e) {
            throw new RuntimeException(e);
        }
        sortables = set.getSortedList();
        check("test update", ((SortableItem)sortables[0]).getValue(), "testupdate");
    }


    static void check(String descr, Long result, Long expected) {
        if (result == null && expected != null || (result != null && expected == null)) {
            System.out.println("FAILED " + descr + "expected " + expected + " but found " + result);
        }
        if (result != null && expected != null) {
            if (!result.equals(expected))
                System.out.println("FAILED " + descr + "expected " + expected + " but found " + result);
        }
    }

    static void check(String descr, String result, String expected) {
        if (result == null && expected != null || (result != null && expected == null)) {
            System.out.println("FAILED " + descr + "expected " + expected + " but found " + result);
        }
        if (result != null && expected != null) {
            if (!result.equals(expected))
                System.out.println("FAILED " + descr + "expected " + expected + " but found " + result);
        }
    }
}
