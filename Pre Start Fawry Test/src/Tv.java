public class Tv extends Product {
    private double screenSize;

    public Tv(String name, int price, double screenSize) {
        super(name, price);
        this.screenSize = screenSize;
    }

    public double getScreenSize() {
        return screenSize;
    }

    @Override
    public String toString() {
        return "TV {" +
                "screenSize = " + screenSize +
                '}';
    }
}
