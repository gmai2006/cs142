
public class DuplicateException extends Exception {
    private long key;

    public DuplicateException(String message) {
        super(message);
    }

    public DuplicateException(String message, long key) {
        super(message);
        this.key = key;
    }

    public DuplicateException(String message, Object extra) {
        super(message);
        this.key = 0;
    }

    public long getKey() {
        return key;
    }
}