package com.rodrigosousa.Loans.controller.dto;

import com.rodrigosousa.Loans.domain.LoanType;

public record LoanResponse(LoanType loanType,
                           Double interestRate) {
}
