package com.rodrigosousa.Loans.domain;

import com.rodrigosousa.Loans.factory.CustomerFactory;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CustomerTest {

    @Nested
    class isIncomeEqualOrLowerThan {

        @Test
        void shouldBeTrueWhenIncomeIsEqual() {
            Customer customer = CustomerFactory.build(5000.0);

            assertTrue(customer.isIncomeEqualOrLowerThan(5000.0));
        }
        @Test
        void shouldBeFalseWhenIncomeIsGreaterThaValue() {
            Customer customer = CustomerFactory.build(5000.0);

            assertFalse(customer.isIncomeEqualOrLowerThan(3000.0));
        }
        @Test
        void shouldBeTrueWhenIncomeIsLowerThan() {
            Customer customer = CustomerFactory.build(5000.0);

            assertTrue(customer.isIncomeEqualOrLowerThan(9000.0));
        }
    }
}