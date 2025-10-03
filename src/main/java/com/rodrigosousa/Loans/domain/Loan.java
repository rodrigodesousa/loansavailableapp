package com.rodrigosousa.Loans.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Loan {

    private Customer customer;

    public boolean isPersonalLoanAvailable() {
        return basicLoanAvailable();
    }

    public double getPersonalLoanInterestRate() {
        if(isPersonalLoanAvailable()) {
            return 4.0;
        }

        throw new LoanNotAvailableException();
    }

    public boolean isConsigmentedLoanAvailable() {
        return customer.isIncomeEqualOrGreaterThan(5000.00);
    }

    public double getConsigmentedLoanInterestRate() {
        if(isConsigmentedLoanAvailable()) {
            return 2.0;
        }

        throw new LoanNotAvailableException();
    }

    public boolean isGaranteedLoanAvailable() {
        return basicLoanAvailable();
    }

    public double getGaranteedLoanInterestRate() {
        if(isGaranteedLoanAvailable()) {
            return 3.0;
        }

        throw new LoanNotAvailableException();
    }

    private boolean basicLoanAvailable() {
        if(customer.isIncomeEqualOrLowerThan(3000.00)) {
            return true;
        }

        return customer.isIncomeBetween(3000.00, 5000.00)
                && customer.isAgeLowerThan(30)
                && customer.isFromLocation("SP");
    }
}
