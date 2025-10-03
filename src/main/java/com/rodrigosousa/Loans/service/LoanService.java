package com.rodrigosousa.Loans.service;

import com.rodrigosousa.Loans.controller.dto.CustomerLoanReponse;
import com.rodrigosousa.Loans.controller.dto.CustomerLoanRequest;
import com.rodrigosousa.Loans.controller.dto.LoanResponse;
import com.rodrigosousa.Loans.domain.Loan;
import com.rodrigosousa.Loans.domain.LoanType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService {

    public CustomerLoanReponse checkLoanAvailability(CustomerLoanRequest loanRequest) {

        var customer = loanRequest.toCustomer();
        var loan = new Loan(customer);

        List<LoanResponse> loans = new ArrayList<>();
        if(loan.isPersonalLoanAvailable()) {
            loans.add(new LoanResponse(LoanType.PERSONAL, loan.getPersonalLoanInterestRate()));
        }

        if(loan.isConsigmentedLoanAvailable()){
            loans.add(new LoanResponse(LoanType.CONSIGMENTED, loan.getConsigmentedLoanInterestRate()));
        }

        if(loan.isGaranteedLoanAvailable()){
            loans.add(new LoanResponse(LoanType.GARANTEED, loan.getGaranteedLoanInterestRate()));
        }

        return new CustomerLoanReponse(loanRequest.name(), loans);
    }
}
