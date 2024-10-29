import java.util.*;

public class SortableSet {
    private List<Sortable> set = new ArrayList<>();

    public void add(Sortable item) throws DuplicateException {
        if (set.stream().anyMatch(s -> s.getSortKey() == item.getSortKey())) {
            throw new DuplicateException("Duplicate key found: " + item.getSortKey());
        }
        set.add(item);
    }

    public void delete(long key) throws InvalidKeyException {
        Sortable item = get(key);
        if (item != null) {
            set.remove(item);
        } else {
            throw new InvalidKeyException("No item with key ", + key + " found for deletion.");
        }
    }

    public void update(Sortable item) throws InvalidKeyException {
        int index = findIndex(item.getSortKey());
        if (index != -1) {
            set.set(index, item);
        } else {
            throw new InvalidKeyException("No item with key ", + item.getSortKey() + " found for update.");
        }
    }

    public Sortable get(long key) throws InvalidKeyException {
        for (Sortable item : set) {
            if (item.getSortKey() == key) {
                return item;
            }
        }
        throw new InvalidKeyException("No item with key ", + key + " found.");
    }

    public long[] getKeys() {
        return set.stream().mapToLong(Sortable::getSortKey).toArray();
    }

    public Sortable[] getSortedList() {
        Sortable[] sortedArray = set.toArray(new Sortable[0]);
        Arrays.sort(sortedArray, Comparator.comparingLong(Sortable::getSortKey));
        return sortedArray;
    }

    private int findIndex(long key) {
        for (int i = 0; i < set.size(); i++) {
            if (set.get(i).getSortKey() == key) {
                return i;
            }
        }
        return -1;
    }
}






