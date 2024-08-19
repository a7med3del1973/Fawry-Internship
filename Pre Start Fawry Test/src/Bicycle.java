public class Bicycle extends Product {
    private double maxSpeed;

    public Bicycle(String name, int price, double maxSpeed) {
        super(name, price);
        this.maxSpeed = maxSpeed;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public String toString() {
        return "Bicycle {" +
                "maxSpeed = " + maxSpeed +
                '}';
    }
}
