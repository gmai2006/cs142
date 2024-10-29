import java.util.*;

public class Repository {
    private String name;
    private Commit head;

    public Repository(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Repository name cannot be null or empty");
        }
        this.name = name;
    }

    public String getRepoHead() {
        if (head == null) {
            return null;
        }
        return head.id;
    }

    @Override
    public String toString() {
        if (head == null) {
            return name + " - No commits";
        }
        return name + " - Current head: " + head.toString();
    }

    public String getHistory(int nHist) {
        if (nHist <= 0) {
            throw new IllegalArgumentException("Number of commits must be positive");
        }
        StringBuilder history = new StringBuilder();
        Commit current = head;
        int count = 0;
        while (current != null && count < nHist) {
            history.insert(0, current.toString() + "\n");
            current = current.past;
            count++;
        }
        return history.toString();
    }

    public String commit(String message) {
        Commit newCommit = new Commit(message, head);
        head = newCommit;
        return newCommit.id;
    }

    public void reset(int nReset) {
        if (nReset <= 0) {
            throw new IllegalArgumentException("Number of commits must be positive");
        }
        Commit current = head;
        for (int i = 0; i < nReset - 1 && current != null; i++) {
            current = current.past;
        }
        head = current;
    }

    public String drop(String idDrop) {
        if (head == null) {
            return null;
        }
        if (head.id.equals(idDrop)) {
            String droppedId = head.id;
            head = head.past;
            return droppedId;
        }
        Commit current = head;
        while (current.past != null) {
            if (current.past.id.equals(idDrop)) {
                String droppedId = current.past.id;
                current.past = current.past.past;
                return droppedId;
            }
            current = current.past;
        }
        return null;
    }

    public String squash(String idSquash) {
        if (head == null || head.past == null) {
            return null;
        }
        if (head.id.equals(idSquash)) {
            return null;
        }
        Commit current = head;
        while (current.past != null) {
            if(current.id.equals(idSquash)) {
                Commit newCommit = new Commit("SQUASHED: " + current.message + " / " + current.past.message, current.past.past);
                current.past = newCommit;
                return current.past.id;
            }
            current = current.past;
        }
        return null;
    }

    public static class Commit {
        public String id;
        public String message;
        public Commit past;

        public Commit(String message, Commit past) {
            this.id = getNewId();
            this.message = message;
            this.past = past;
        }

        public Commit(String message) {
            this(message, null);
        }

        public String toString() {
            return id + ": " + message;
        }

        private static String getNewId() {
            return UUID.randomUUID().toString();
        }
    }
}

