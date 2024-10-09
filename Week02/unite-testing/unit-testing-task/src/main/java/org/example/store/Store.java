package org.example.store;

import org.example.account.Customer;

public interface Store {
    void buy(Product product, Customer customer);
}
