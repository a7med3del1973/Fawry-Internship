public class MotorBike extends Product {
    private double maxSpeed;

    public MotorBike(String name, int price, double maxSpeed) {
        super(name, price);
        this.maxSpeed = maxSpeed;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public String toString() {
        return "MotorBike {" +
                "maxSpeed = " + maxSpeed +
                '}';
    }
}
