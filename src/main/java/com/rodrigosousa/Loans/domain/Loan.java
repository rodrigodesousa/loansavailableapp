package com.rodrigosousa.Loans.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Loan {

    private Customer customer;

    public boolean isPersonalLoanAvailable() {
        if(customer.isIncomeEqualOrLowerThan(3000.00)) {
            return true;
        }

        return customer.isIncomeBetween(3000.00, 5000.00)
                && customer.isAgeLowerThan(30)
                && customer.isFromLocation("SP");
    }

    public double getPersonalLoanInterestRate() {
        if(isPersonalLoanAvailable()) {
            return 4.0;
        }

        throw new LoanNotAvailableException();
    }
}
