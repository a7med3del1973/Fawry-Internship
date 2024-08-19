public class Fridge extends Product {
    private double maxFreezingDegree;

    public Fridge(String name, int price, double maxFreezingDegree) {
        super(name, price);
        this.maxFreezingDegree = maxFreezingDegree;
    }

    public double getMaxFreezingDegree() {
        return maxFreezingDegree;
    }

    @Override
    public String toString() {
        return "Fridge {" +
                "maxFreezingDegree = " + maxFreezingDegree +
                '}';
    }
}
