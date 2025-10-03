package com.rodrigosousa.Loans.controller;

import com.rodrigosousa.Loans.controller.dto.CustomerLoanReponse;
import com.rodrigosousa.Loans.controller.dto.CustomerLoanRequest;
import com.rodrigosousa.Loans.service.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping(value = "/customers-loans")
    public ResponseEntity<CustomerLoanReponse> customersLoans(@RequestBody CustomerLoanRequest request) {
        var loanResponse = loanService.checkLoanAvailability(request);
        return ResponseEntity.ok(loanResponse);
    }
}
