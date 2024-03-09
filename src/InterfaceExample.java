public class InterfaceExample {

    public static void main(String[] args) {
        Payable acct1 = new Accounting1();
        Payable acct2 = new Accounting2();


    }

    static interface Payable {
        double getTotalAmount();
        void calculateTotalAmount(double invoice, double tax);
    }

    static abstract class Accounting implements Payable {
        double totalAmount;
        public double getTotalAmount() {
            return totalAmount;
        }
    }
    static class Accounting1 extends Accounting {
        public void calculateTotalAmount(double invoice, double tax) {
            totalAmount = invoice + tax;
        }
    }

    static class Accounting2 extends Accounting  {
        public void calculateTotalAmount(double invoice, double tax) {
            totalAmount = invoice + tax;
        }
    }

}
