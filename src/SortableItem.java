import java.util.Objects;

public class SortableItem implements Sortable {
    long key;
    String value;

    public SortableItem(long key, String val) {
        this.key = key;
        this.value = val;
    }

    /**
     *
     * @return the key.
     */
    @Override
    public long getSortKey() {
        return key;
    }

    @Override
    public Sortable getDeepCopy() {
        SortableItem copy = new SortableItem(this.key, this.value);
        return copy;
    }


    public long getKey() {
        return key;
    }

    public void setKey(long key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SortableItem that = (SortableItem) o;
        return key == that.key && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}
