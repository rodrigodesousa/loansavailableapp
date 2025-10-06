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
    @Nested
    class isIncomeEqualOrGreaterThan {

        @Test
        void shouldBeTrueWhenIncomeIsEqual() {
            Customer customer = CustomerFactory.build(5000.0);

            assertTrue(customer.isIncomeEqualOrGreaterThan(5000.0));
        }
        @Test
        void shouldBeTrueWhenIncomeIsGreaterThaValue() {
            Customer customer = CustomerFactory.build(5000.0);

            assertTrue(customer.isIncomeEqualOrGreaterThan(3000.0));
        }
        @Test
        void shouldBeFalseWhenIncomeIsLowerThan() {
            Customer customer = CustomerFactory.build(5000.0);

            assertFalse(customer.isIncomeEqualOrGreaterThan(9000.0));
        }
    }

    @Nested
    class isIncomeBetween {

        @Test
        void shouldBeTrueWhenIncomeIsBetween() {
            Customer customer = CustomerFactory.build(5000.0);

            assertTrue(customer.isIncomeBetween(3000.0, 8000.0));
        }
        @Test
        void shouldBeFalseWhenIncomeIsNotBetween() {
            Customer customer = CustomerFactory.build(5000.0);

            assertFalse(customer.isIncomeBetween(3000.0, 4000.0));
        }
        @Test
        void shouldBeTrueWhenIncomeIsEqualToMin() {
            Customer customer = CustomerFactory.build(3000.0);

            assertTrue(customer.isIncomeBetween(3000.0, 8000.0));
        }
        @Test
        void shouldBeTrueWhenIncomeIsEqualToMax() {
            Customer customer = CustomerFactory.build(8000.0);

            assertTrue(customer.isIncomeBetween(3000.0, 8000.0));
        }
    }
    @Nested
    class isAgeLowerThan {

        @Test
        void shouldBeTrueWhenAgeIsLowerThan() {
            Customer customer = CustomerFactory.build(25);

            assertTrue(customer.isAgeLowerThan(30));
        }
        @Test
        void shouldBeFalseWhenAgeIsNotLowerThan() {
            Customer customer = CustomerFactory.build(25);

            assertFalse(customer.isAgeLowerThan(22));
        }
        @Test
        void shouldBeFalseWhenAgeIsEqual() {
            Customer customer = CustomerFactory.build(25);

            assertFalse(customer.isAgeLowerThan(25));
        }
    }

    @Nested
    class isFromLocation {

        @Test
        void shouldBeTrueWhenLocationIsTheSame() {
            Customer customer = CustomerFactory.build("SP");

            assertTrue(customer.isFromLocation("SP"));
        }
        @Test
        void shouldBeFalseWhenLocationIsNotTheSame() {
            Customer customer = CustomerFactory.build("SP");

            assertFalse(customer.isFromLocation("RJ"));
        }
    }
}