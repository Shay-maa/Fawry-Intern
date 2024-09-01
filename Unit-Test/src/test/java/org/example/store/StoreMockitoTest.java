package org.example.store;

import org.example.account.AccountManager;
import org.example.account.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.assertj.core.api.Java6Assertions.assertThat;


import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

public class StoreMockitoTest {

    Store store;

    Product product = new Product();
    Customer customer = new Customer();


    @Test void test1() {
        // Arrange
        product.setQuantity(8);
        AccountManager accountManager = Mockito.mock(AccountManager.class);
        when(accountManager.withdraw(any(), anyInt())).thenReturn("success");
        store = new StoreImpl(accountManager);

        // Act
        store.buy(product, customer);

        // Assert
        Assertions.assertEquals(7, product.getQuantity());
    }
    @Test void test2() {
        // Arrange
        product.setQuantity(8);
        AccountManager accountManager = Mockito.mock(AccountManager.class);
        when(accountManager.withdraw(any(), anyInt())).thenReturn("insufficient account balance");
        store = new StoreImpl(accountManager);

        // Act
        try{
            store.buy(product, customer);
        }catch (RuntimeException e){
            Assertions.assertEquals("Payment failure: insufficient account balance",e.getMessage());
        }
        // Assert
        Assertions.assertEquals(8, product.getQuantity());
    }

    @Test void test3() {
        // Arrange
        product.setQuantity(8);
        AccountManager accountManager = Mockito.mock(AccountManager.class);
        when(accountManager.withdraw(any(), anyInt())).thenReturn("maximum credit exceeded");
        store = new StoreImpl(accountManager);

        // Act
        try {
            store.buy(product, customer);
        }catch (RuntimeException e){
            Assertions.assertEquals("Payment failure: maximum credit exceeded",e.getMessage());
        }

        // Assert
        Assertions.assertEquals(8, product.getQuantity());
    }
    @Test void test4() {
        // Arrange
        product.setQuantity(0);
        AccountManager accountManager = Mockito.mock(AccountManager.class);
//        when(accountManager.withdraw(any(), anyInt())).thenReturn("success");
        store = new StoreImpl(accountManager);

        // Act &Assert
        try {
            store.buy(product, customer);
        }catch (RuntimeException e){
            Assertions.assertEquals("Product out of stock",e.getMessage());
        }

    }

}
