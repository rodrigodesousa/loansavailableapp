package com.rodrigosousa.Loans.domain;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class LoanTest {

    @Mock
    private Customer customer;

    @InjectMocks
    private Loan loan;

    @Nested
    class isPersonalLoanAvailable {
        @Test
        void shouldBeAvailableWhenIncomeIsEqualOrLowerThan3000() {
            doReturn(true).when(customer).isIncomeEqualOrLowerThan(3000.00);

            assertTrue(loan.isPersonalLoanAvailable());
        }
        @Test
        void shouldBeAvailableWhenIncomeIsBetween3000And5000AgeIsLessThan30AndLocationIsSP() {
            doReturn(false).when(customer).isIncomeEqualOrLowerThan(3000.00);
            doReturn(true).when(customer).isIncomeBetween(3000.00, 5000.00);
            doReturn(true).when(customer).isAgeLowerThan(30);
            doReturn(true).when(customer).isFromLocation("SP");

            assertTrue(loan.isPersonalLoanAvailable());
        }
    }

    @Nested
    class isGaranteedLoanAvailable {
        @Test
        void shouldBeAvailableWhenIncomeIsEqualOrLowerThan3000() {
            doReturn(true).when(customer).isIncomeEqualOrLowerThan(3000.00);

            assertTrue(loan.isGaranteedLoanAvailable());
        }
        @Test
        void shouldBeAvailableWhenIncomeIsBetween3000And5000AgeIsLessThan30AndLocationIsSP() {
            doReturn(false).when(customer).isIncomeEqualOrLowerThan(3000.00);
            doReturn(true).when(customer).isIncomeBetween(3000.00, 5000.00);
            doReturn(true).when(customer).isAgeLowerThan(30);
            doReturn(true).when(customer).isFromLocation("SP");

            assertTrue(loan.isGaranteedLoanAvailable());
        }
    }

    @Nested
    class isConsigmentedLoanAvailable {
        @Test
        void shouldBeAvailableWhenIncomeIsEqualOrGreaterThan5000() {
            doReturn(true).when(customer).isIncomeEqualOrGreaterThan(5000.00);

            assertTrue(loan.isConsigmentedLoanAvailable());
        }
        @Test
        void shouldNotBeAvailableWhenIncomeIsEqual4000() {
            doReturn(false).when(customer).isIncomeEqualOrGreaterThan(5000.00);

            assertFalse(loan.isConsigmentedLoanAvailable());
        }
    }

    @Nested
    class getPersonalLoanInterestRate {
        @Test
        void shouldTheInterestRateBe4() {
            doReturn(true).when(customer).isIncomeEqualOrLowerThan(3000.00);

            assertEquals(4.0, loan.getPersonalLoanInterestRate());
        }
        @Test
        void shouldThrowExceptionWhenIsNotAvailable() {
            doReturn(false).when(customer).isIncomeEqualOrLowerThan(3000.00);

            assertThrows(LoanNotAvailableException.class, () -> loan.getPersonalLoanInterestRate());
        }
    }

    @Nested
    class getGaranteedLoanInterestRate {
        @Test
        void shouldTheInterestRateBe3() {
            doReturn(true).when(customer).isIncomeEqualOrLowerThan(3000.00);

            assertEquals(3.0, loan.getGaranteedLoanInterestRate());
        }
        @Test
        void shouldThrowExceptionWhenIsNotAvailable() {
            doReturn(false).when(customer).isIncomeEqualOrLowerThan(3000.00);

            assertThrows(LoanNotAvailableException.class, () -> loan.getGaranteedLoanInterestRate());
        }
    }

    @Nested
    class getConsigmentedLoanInterestRate {
        @Test
        void shouldTheInterestRateBe2() {
            doReturn(true).when(customer).isIncomeEqualOrGreaterThan(5000.00);

            assertEquals(2.0, loan.getConsigmentedLoanInterestRate());
        }
        @Test
        void shouldThrowExceptionWhenIsNotAvailable() {
            doReturn(false).when(customer).isIncomeEqualOrGreaterThan(5000.00);

            assertThrows(LoanNotAvailableException.class, () -> loan.getConsigmentedLoanInterestRate());
        }
    }
}