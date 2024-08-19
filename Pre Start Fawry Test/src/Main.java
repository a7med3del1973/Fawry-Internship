import java.util.Arrays;
import java.util.List;

public class Main {


    public static void main(String[] args) throws Exception {
        // Done
        Car bmwCar = new Car("BMW", 500000, 200, "gas");
        MotorBike hondaBike = new MotorBike("Honda", 200000, 100);
        List<Product> list = Arrays.asList(bmwCar, hondaBike);
        Shop shop = new Shop();
        Product fastest = shop.getFastest(list);
        System.out.println("The Fastest vehicle is : " + fastest);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Done
        Car bmwCar2 = new Car("BMW", 500000, 200, "gas");
        Tv lgTv2 = new Tv("LG 50inch", 15000, 50);
        shop.addProduct(bmwCar2, 1);
        shop.addProduct(lgTv2, 1);
        List<Product> list2 = Arrays.asList(bmwCar2, lgTv2);
        try {
            double answer = shop.calcPrice(list2);
            System.out.println("The Total Price is : " + answer);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}