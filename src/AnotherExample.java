import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnotherExample {
    public static void main(String[] args) {

        ArrayList<InterestCheckingAccount> accounts = new ArrayList<>(Arrays.asList(
                new DailyCheckingAccount(500),
                new QuarterlyCheckingAccount(600)));

        accounts.forEach(account -> account.getInterest());

    }

    static class CheckingAccount {
        double balance;

        public CheckingAccount(double bal) {

        }
        public double getBalance() {
            return balance;
        }
    }

    static class InterestCheckingAccount extends CheckingAccount {

        double interest;

        public InterestCheckingAccount(double bal) {
            super(bal);
        }

        public double getInterest() {
            return interest;
        }
    }

    static class DailyCheckingAccount extends InterestCheckingAccount {
        public DailyCheckingAccount(double bal) {
            super(bal);
        }
    }

    static class QuarterlyCheckingAccount extends InterestCheckingAccount {
        public QuarterlyCheckingAccount(double bal) {
            super(bal);
        }
    }


}
