public abstract class SpecialtyItem extends Item {

    public SpecialtyItem(long idNum, String model, double cost) {
        super(idNum, model, cost);
    }

    public abstract double calcAddedExpense();

    @Override
    public double calcPrice() {
        return getCost() + calcAddedExpense();
    }
}

class SpecialtyItem1 extends SpecialtyItem {

    public SpecialtyItem1(long idNum, String model, double cost) {
        super(idNum, model, cost);
    }

    public double calcAddedExpense() {
        return 6.;
    }
}

class SpecialtyItem2 extends SpecialtyItem {

    public SpecialtyItem2(long idNum, String model, double cost) {
        super(idNum, model, cost);
    }

    public double calcAddedExpense() {
        return 5.;
    }

}