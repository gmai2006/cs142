
public class InvalidKeyException extends Exception {
    private final long key;

    public InvalidKeyException(String message, long key) {
        super(message);
        this.key = key;
    }

    public InvalidKeyException(String message, Object test) {
        super(message);
        this.key = 0;
    }

    public long getKey() {
        return key;
    }
}