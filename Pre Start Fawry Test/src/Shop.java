import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Shop {
    Map<Product, Integer> stock = new HashMap<>();

    public void addProduct(Product product, int quantity) {
        stock.put(product, stock.getOrDefault(product, 0) + quantity);
    }

    public double calcPrice(List<Product> products) throws Exception {
        double total = 0;
        for (Product it : products) {
            if (!stock.containsKey(it) || stock.get(it) < 1) {
                throw new Exception("Unfortunately The Product " + it.getName() + " is out of stock !");
            }
            total += it.getPrice();
            stock.put(it, stock.get(it) - 1);
        }
        return total;
    }

    public Product getFastest(List<Product> products) {
        Product fastest = null;
        double maxSpeed = 0;

        for (Product it : products) {
            if (it instanceof Car) {
                if (((Car) it).getMaxSpeed() > maxSpeed) {
                    maxSpeed = ((Car) it).getMaxSpeed();
                    fastest = it;
                }
            } else if (it instanceof MotorBike) {
                if (((MotorBike) it).getMaxSpeed() > maxSpeed) {
                    maxSpeed = ((MotorBike) it).getMaxSpeed();
                    fastest = it;
                }
            } else if (it instanceof Bicycle) {
                if (((Bicycle) it).getMaxSpeed() > maxSpeed) {
                    maxSpeed = ((Bicycle) it).getMaxSpeed();
                    fastest = it;
                }
            }
        }
        return fastest;
    }
}
