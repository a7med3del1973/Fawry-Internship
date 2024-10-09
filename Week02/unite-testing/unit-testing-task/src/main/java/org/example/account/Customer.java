package org.example.account;

import lombok.Data;

@Data
public class Customer {

    private String name;
    private int balance;
    private boolean creditAllowed;
    private boolean vip;

}
