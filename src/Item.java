import java.util.Objects;

public class Item {

    //fields
    public final long ID_NUM;
    private String model;
    private double cost;

    public Item(long idNum, String model, double cost) {
        ID_NUM = idNum;
        this.model = model;
        this.cost = cost;
    }

    //TODO create getters and setters for private fields

    public double getCost() {
        return cost;
    }

    public double calcPrice() {
        return cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return ID_NUM == item.ID_NUM && Double.compare(item.cost, cost) == 0 && model.equals(item.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID_NUM, model, cost);
    }

    @Override
    public String toString() {
        return "Item{" +
                "ID_NUM=" + ID_NUM +
                ", model='" + model + '\'' +
                ", cost=" + cost +
                '}';
    }
}