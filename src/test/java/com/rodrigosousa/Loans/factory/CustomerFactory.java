package com.rodrigosousa.Loans.factory;

import com.rodrigosousa.Loans.domain.Customer;

public class CustomerFactory {

    public static Customer build(Double income){
        return new Customer(25,"043.123.456-00", "Name", income, "SP");
    }
}
