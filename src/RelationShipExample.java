public class RelationShipExample {

    public static void main(String[] args) {
        CreditCard creditCard = new CreditCard("000000000");
        Address address = new Address("42 Wallaby Way", "Sydney", "New South Wales");
        Customer customer = new Customer("Nemo", address, creditCard);
        Purchase purchase = new Purchase(1000, customer);
        System.out.println(purchase);
    }

    static class Customer {
        String name;
        CreditCard creditCard;
        Address address;

        public Customer(String name, Address address, CreditCard creditCard) {
            this.name = name;
            this.address = address;
            this.creditCard = creditCard;
        }

        public String getName() { return name; }

        @Override
        public String toString() {
            return name + ", " + address + ", " + creditCard;
        }
    }

    static class CreditCard {
        String cardNumber;

        public CreditCard(String number) {
            this.cardNumber = number;
        }

        public String getCardNumber() { return cardNumber; }

        @Override
        public String toString() {
            return cardNumber;
        }

    }

    static class Address {
        String street;
        String state;
        String city;


        public Address(String street, String city, String state) {
            this.street = street;
            this.state = state;
            this.city = city;
        }

        @Override
        public String toString() {
            return "Address{" +
                    "street='" + street + '\'' +
                    ", state='" + state + '\'' +
                    ", city='" + city + '\'' +
                    '}';
        }
    }

    static class Purchase {
        double total;
        Customer customer;

        public Purchase(double total, Customer customer) {
            this.total = total;
            this.customer = customer;
        }

        @Override
        public String toString() {
            return total + ": " + customer.toString();
        }
    }
}
