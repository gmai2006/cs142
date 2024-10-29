import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InterfaceExample2 {

    public static void main(String[] args) {
        Paylable[] employees = {
                new CommissionEmployee("John", "Doe", 200.56, 0.1),
                new HourEmployee("Jan", "Doe1", 30.5, 176),
                new SalaryEmployee("Jon2", "Doe2", 4000.5)
        };

        for (Paylable employee : employees) {
            System.out.println(employee.getPaymentAmount());
        }

        final List<Paylable> list = Arrays.asList(employees);

        Collections.sort(list);
        System.out.println(list);
        int result = Collections.binarySearch(list, new HourEmployee("John", "Doe2", 30.5, 176));
        System.out.println(result);

        Collections.sort(list, new SortEmployeeByFirstName());
    }
    public static interface Paylable extends Comparable<Paylable> {
        double getPaymentAmount();
    }

    public static class SortEmployeeByFirstName implements Comparator<Paylable> {
        @Override
        public int compare(Paylable o1, Paylable o2) {
            return ((Employee)o1).firstName.compareTo(((Employee)o2).firstName);
        }
    }
    static abstract class Employee implements  Paylable, Serializable {
        String lastName;
        String firstName;

        public Employee(String lastName, String firstName) {
            this.lastName = lastName;
            this.firstName = firstName;
        }

        @Override
        public int compareTo(Paylable other) {
            return this.lastName.compareTo(((Employee)other).lastName);
        }

        @Override
        public String toString() {
            return lastName + ", " + firstName;
        }
    }

    static class CommissionEmployee extends Employee {
        double grossSale;
        double commissionRate;

        public CommissionEmployee(String lastName, String firstName, double grossSale, double commissionRate) {
            super(lastName, firstName);
            this.grossSale = grossSale;
            this.commissionRate = commissionRate;
        }



        @Override
        public double getPaymentAmount() {
            return grossSale * commissionRate;
        }
    }

    static class HourEmployee extends Employee {
        double wage;
        double hours;

        public HourEmployee(String lastName, String firstName, double wage, double hours) {
            super(lastName, firstName);
            this.wage = wage;
            this.hours = hours;
        }

        @Override
        public double getPaymentAmount() {
            return wage * hours;
        }
    }

    static class SalaryEmployee extends Employee {
        double weeklySalary;

        public SalaryEmployee(String lastName, String firstName, double weeklySalary) {
            super(lastName, firstName);
            this.weeklySalary = weeklySalary;
        }

        @Override
        public double getPaymentAmount() {
            return weeklySalary * 4;
        }
    }

    //BonusCommissionEmployee & Invoice => students will implement

}
