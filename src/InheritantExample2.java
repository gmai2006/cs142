public class InheritantExample2 {
    public static void main(String[] args) {
        CheckingAccount[] accounts = {
                new QuarterChecking(2000, "1", 0.07),
                new MonthlyChecking(2000, "2", 0.05),
                new DailyChecking(2000, "3", 0.03),
        };

        for (CheckingAccount account : accounts) {
            if (account instanceof InterestEarningChecking) {
                System.out.println(((InterestEarningChecking)account).calculateInterest());
            }
        }
    }

    static class CheckingAccount {
        private double balance;
        private final String ACCOUNT_NUMBER;

        public CheckingAccount(double balance, String accountNumber) {
            this.balance = balance;
            this.ACCOUNT_NUMBER = accountNumber;
        }

        public double getBalance() { return balance; }
        public void setBalance(double balance) { this.balance = balance; }
    }

    static abstract class InterestEarningChecking extends CheckingAccount {

        double interest;

        public InterestEarningChecking(double balance, String accountNumber, double interest) {
            super(balance, accountNumber);
            this.interest = interest;
        }

        public double getInterest() { return interest; }

        public abstract double calculateInterest();

    }

    static class QuarterChecking extends InterestEarningChecking {
        public QuarterChecking(double balance, String accountNumber, double interest) {
            super(balance, accountNumber, interest);
        }

        @Override
        public double calculateInterest() {
            return getBalance() * getInterest() * 3;
        }
    }

    static class MonthlyChecking extends InterestEarningChecking {
        public MonthlyChecking(double balance, String accountNumber, double interest) {
            super(balance, accountNumber, interest);
        }

        @Override
        public double calculateInterest() {
            return getBalance() * getInterest() * 2;
        }
    }

    static class DailyChecking extends InterestEarningChecking {
        public DailyChecking(double balance, String accountNumber, double interest) {
            super(balance, accountNumber, interest);
        }

        @Override
        public double calculateInterest() {
            return getBalance() * getInterest() * 3;
        }
    }
}


