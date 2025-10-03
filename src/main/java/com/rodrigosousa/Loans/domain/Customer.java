package com.rodrigosousa.Loans.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Customer {

    private Integer age;
    private String cpf;
    private String name;
    private Double income;
    private String location;

    public boolean isIncomeEqualOrLowerThan(double value) {
        return income <= value;
    }

    public boolean isIncomeBetween(double min, double max) {
        return income >= min && income <= max;
    }

    public boolean isAgeLowerThan(int value) {
        return age < value;
    }

    public boolean isFromLocation(String loc) {
        return location.equalsIgnoreCase(loc);
    }

    public boolean isIncomeEqualOrGreaterThan(double value) {
        return income >= value;
    }
}
