package org.example.account;

import lombok.var;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountManagerImplDepositTest {

    @Test
    void testTwoHundredShouldReturn1200() {
        var temp1 = new AccountManagerImpl();
        var customer1 = new Customer();
        customer1.setName("Ahmed");
        customer1.setBalance(1000);
        customer1.setCreditAllowed(true);
        customer1.setVip(false);
        temp1.deposit(customer1, 200);
        assertEquals(1200, customer1.getBalance());
    }

    @Test
    void testZeroBalanceShouldReturnTheBalance() {
        var account = new AccountManagerImpl();
        var customer = new Customer();
        customer.setName("Hany");
        customer.setBalance(0);
        customer.setCreditAllowed(false);
        customer.setVip(false);
        account.deposit(customer, 0);
        assertEquals(0, customer.getBalance());
    }

    @Test
    void testWithdraw100shouldReturn400() {
        var account = new AccountManagerImpl();
        var customer = new Customer();
        customer.setName("Mohamed");
        customer.setBalance(500);
        customer.setVip(false);
        customer.setCreditAllowed(true);
        account.withdraw(customer, 100);
        assertEquals(400, customer.getBalance());
    }

    @Test
    void testInsufficientAccountBalance() {
        var account = new AccountManagerImpl();
        var customer = new Customer();
        customer.setName("Ali");
        customer.setCreditAllowed(false);
        customer.setVip(false);
        customer.setBalance(100);
        String result = account.withdraw(customer, 1200);
        assertEquals("insufficient account balance", result);

    }
    @Test
    void testSetName() {
        var customer = new Customer();
        customer.setName("Sara");
        assertEquals("Sara", customer.getName());
    }

    @Test
    void testVipStatus() {
        var customer = new Customer();
        customer.setVip(true);
        assertTrue(customer.isVip());

        customer.setVip(false);
        assertFalse(customer.isVip());
    }

    @Test
    void testCustomerNameAndVip() {
        var customer = new Customer();
        customer.setName("John");
        customer.setVip(true);

        assertEquals("John", customer.getName());
        assertTrue(customer.isVip());
    }

    @Test
    void testVipCustomerBalanceAfterDeposit() {
        var accountManager = new AccountManagerImpl();
        var customer = new Customer();
        customer.setName("David");
        customer.setBalance(300);
        customer.setVip(true);
        customer.setCreditAllowed(true);

        accountManager.deposit(customer, 500);
        assertEquals(800, customer.getBalance());
    }


}