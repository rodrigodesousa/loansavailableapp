package com.rodrigosousa.Loans.controller.dto;

import java.util.List;

public record CustomerLoanReponse(String customer,
                                  List<LoanResponse> loans) {
}
