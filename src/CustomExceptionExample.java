public class CustomExceptionExample {
    public static  void main(String[] args) {
        try {
            getCreditCardNumber("121212121212");
            getCreditCardNumber("123456789012345");
        } catch (CreditCardException ce) {
            System.out.println(ce);
        }
    }

    static String getCreditCardNumber(String value) throws CreditCardException {
        if (value == null || value.length() != 16) {
            throw new CreditCardException("Invalid credit number " + value);
        }
        return value;
    }

    static class CreditCardException extends Exception {
        public CreditCardException(String message) {
            super(message);
        }
    }
}
