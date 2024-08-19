public class Car extends Product {
    private double maxSpeed;
    private String engineType;

    public Car(String name, int price, double maxSpeed, String engineType) {
        super(name, price);
        this.maxSpeed = maxSpeed;
        this.engineType = engineType;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public String getEngineType() {
        return engineType;
    }

    @Override
    public String toString() {
        return "Car {" +
                "maxSpeed = " + maxSpeed +
                ", engineType = '" + engineType + '\'' +
                '}';
    }
}
