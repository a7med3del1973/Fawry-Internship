package org.example.store;

import org.example.account.AccountManager;
import org.example.account.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StoreImplTest {

    Store store;
    Product product;
    Customer customer;

    @BeforeEach
    void setUp() {
        product = new Product();
        customer = new Customer();
    }

    static class AlwaysReturnSuccessAccountManager implements AccountManager {
        @Override
        public void deposit(Customer customer, int amount) { }

        @Override
        public String withdraw(Customer customer, int amount) {
            return "success";
        }
    }

    static class AlwaysFailAccountManager implements AccountManager {
        @Override
        public void deposit(Customer customer, int amount) { }

        @Override
        public String withdraw(Customer customer, int amount) {
            return "failure";
        }
    }

    @Test
    void testBuySuccess() {
        // Arrange
        product.setQuantity(8);
        store = new StoreImpl(new AlwaysReturnSuccessAccountManager());

        // Act
        store.buy(product, customer);

        // Assert
        Assertions.assertEquals(7, product.getQuantity());
    }

    @Test
    void testBuyProductOutOfStock() {
        // Arrange
        product.setQuantity(0);
        store = new StoreImpl(new AlwaysReturnSuccessAccountManager());

        // Act & Assert
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> store.buy(product, customer));
        Assertions.assertEquals("Product out of stock", exception.getMessage());
    }

    @Test
    void testBuyPaymentFailure() {
        // Arrange
        product.setQuantity(8);
        store = new StoreImpl(new AlwaysFailAccountManager());

        // Act & Assert
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> store.buy(product, customer));
        Assertions.assertEquals("Payment failure: failure", exception.getMessage());
    }

    @Test
    void testSetName() {
        // Arrange
        String expectedName = "Laptop";

        // Act
        product.setName(expectedName);

        // Assert
        Assertions.assertEquals(expectedName, product.getName());
    }

    @Test
    void testSetPrice() {
        // Arrange
        int expectedPrice = 1500;

        // Act
        product.setPrice(expectedPrice);

        // Assert
        Assertions.assertEquals(expectedPrice, product.getPrice());
    }

    @Test
    void testSetQuantity() {
        // Arrange
        int expectedQuantity = 50;

        // Act
        product.setQuantity(expectedQuantity);

        // Assert
        Assertions.assertEquals(expectedQuantity, product.getQuantity());
    }

    @Test
    void testProductInitialization() {
        // Arrange
        product.setName("Smartphone");
        product.setPrice(800);
        product.setQuantity(20);

        // Act & Assert
        Assertions.assertEquals("Smartphone", product.getName());
        Assertions.assertEquals(800, product.getPrice());
        Assertions.assertEquals(20, product.getQuantity());
    }
}
