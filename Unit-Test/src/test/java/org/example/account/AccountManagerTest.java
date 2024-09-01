package org.example.account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class AccountManagerTest {

    Customer customer = new Customer();
    AccountManager accountManager = new AccountManagerImpl();

    @Test void givenValidAmountWhenDepositThenSuccess(){
        // Arrange
        int balance = customer.getBalance();

        // Act
        accountManager.deposit(customer, 100);

        // Assert
        assertThat(balance+100).isEqualTo(customer.getBalance());
//        int actualBalance = customer.getBalance();
//        Assertions.assertEquals(balance+100, actualBalance);
    }
    @Test void givenAmountBelowMaxCreditForNormalCustomerWhenWithdrawThenSubtractFromBalance() {
        // Arrange
        customer.setBalance(100);

        // Act
        String result = accountManager.withdraw(customer, 80);

        // Assert
        assertThat(20).isEqualTo(customer.getBalance());
        assertThat(result).isEqualTo("success");

//        int expectedBalance = customer.getBalance();
//        Assertions.assertEquals(20, expectedBalance);
//        Assertions.assertEquals("success", result);
    }
    @Test void givenAmountBelowTheBalanceForNormalCustomerWhenWithdrawThenFailed(){
    // Arrange
    customer.setBalance(100);
    customer.setCreditAllowed(false);

    // Act
    String result = accountManager.withdraw(customer, 120);

    // Assert
        assertThat(result).isEqualTo("insufficient account balance");
   // Assertions.assertEquals("insufficient account balance", result);
}
    @Test void givenAmountBelowTheBalanceAndMaxCreditForNormalCustomerWithCreditAllowedWhenWithdrawThenSuccess(){
        // Arrange
        customer.setBalance(100);
        customer.setCreditAllowed(true);
        customer.setVip(false);

        // Act
        String result = accountManager.withdraw(customer, 200);

        // Assert
        assertThat(result).isEqualTo("success");
     //   Assertions.assertEquals("success", result);
    }
    @Test void givenAmountBelowTheBalanceAndOverTheMaxCreditForNormalCustomerWithCreditAllowedWhenWithdrawThenFailed(){
        // Arrange
        customer.setBalance(100);
        customer.setCreditAllowed(true);
        customer.setVip(false);

        // Act
        String result = accountManager.withdraw(customer, 1200);

        // Assert
        assertThat(result).isEqualTo("maximum credit exceeded");
       // Assertions.assertEquals("maximum credit exceeded", result);
    }
    @Test void givenAmountBelowTheBalanceAndOverTheMaxCreditForVipCustomerWithCreditAllowedWhenWithdrawThenSuccess(){
        // Arrange
        customer.setBalance(100);
        customer.setCreditAllowed(true);
        customer.setVip(true);

        // Act
        String result = accountManager.withdraw(customer, 1200);

        // Assert
        assertThat(result).isEqualTo("success");
//        Assertions.assertEquals("success", result);
    }
}
