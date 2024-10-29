import java.util.*;

public class GitClient {
    private static List<String> ops = new ArrayList<>();

    public static void main(String[] args) {
        Collections.addAll(ops, "create", "head", "history", "commit", "reset", "drop", "squash", "quit");
        Scanner console = new Scanner(System.in);
        Map<String, Repository> repos = new HashMap<>();
        String op = "";
        String name = "";

        intro();

        while (!op.equalsIgnoreCase("quit")) {
            System.out.println("Available repositories: ");
            for (Repository repo : repos.values()) {
                System.out.println("\t" + repo);
            }
            System.out.println("Operations: " + ops);
            System.out.print("Enter operation and repository: ");
            String[] input = console.nextLine().split("\\s+");
            op = input[0];
            name = input.length > 1 ? input[1] : "";
            while (!ops.contains(op) || (!op.equalsIgnoreCase("create") && !op.equalsIgnoreCase("quit") && !repos.containsKey(name))) {
                System.out.println("  **ERROR**: Operation or repository not recognized.");
                System.out.print("Enter operation and repository: ");
                input = console.nextLine().split("\\s+");
                op = input[0];
                name = input.length > 1 ? input[1] : "";
            }

            Repository currRepo = repos.get(name);
            switch (op.toLowerCase()) {
                case "create":
                    if (currRepo != null) {
                        System.out.println("  **ERROR**: Repository with that name already exists.");
                    } else {
                        Repository newRepo = new Repository(name);
                        repos.put(name, newRepo);
                        System.out.println("  New repository created: " + newRepo);
                    }
                    break;
                case "head":
                    System.out.println(currRepo.getRepoHead());
                    break;
                case "history":
                    System.out.print("How many commits back? ");
                    int nHist = console.nextInt();
                    console.nextLine();
                    System.out.println(currRepo.getHistory(nHist));
                    break;
                case "commit":
                    System.out.print("Enter commit message: ");
                    String message = console.nextLine();
                    System.out.println("  New commit: " + currRepo.commit(message));
                    break;
                case "reset":
                    System.out.print("How many commits back? ");
                    int nReset = console.nextInt();
                    console.nextLine();
                    currRepo.reset(nReset);
                    System.out.println("  New head: " + currRepo.getRepoHead());
                    break;
                case "drop":
                    System.out.print("Enter ID to drop: ");
                    String idDrop = console.nextLine();
                    String dropped = currRepo.drop(idDrop);
                    if (dropped == null) {
                        System.out.println("  No commit dropped!");
                    } else {
                        System.out.println("  Dropped " + dropped);
                    }
                    break;
                case "squash":
                    System.out.print("Enter ID to squash: ");
                    String idSquash = console.nextLine();
                    String squashed = currRepo.squash(idSquash);
                    if (squashed == null) {
                        System.out.println("  No commits squashed!");
                    } else {
                        System.out.println("  Squashed and removed " + squashed);
                    }
                    break;
            }
            System.out.println();
        }
    }

    public static void intro() {
        System.out.println("Welcome to the Mini-Git test client!");
        System.out.println("Use this program to test your Mini-Git repository implementation.");
        System.out.println("Make sure to test all operations in all cases--");
        System.out.println("sometimes certain cases are particularly tricky.");
        System.out.println();
    }
}
