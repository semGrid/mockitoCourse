package com.griddynamics;

import com.griddynamics.transfer.MoneyTransferApplication;
import com.griddynamics.transfer.domain.TransferTransaction;
import com.griddynamics.transfer.validators.BankCodeValidator;
import com.griddynamics.transfer.validators.CurrencyCodeValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(SpringJUnit4ClassRunner.class)
@PowerMockIgnore("javax.management.*")
@PrepareForTest(value = {CurrencyCodeValidator.class, BankCodeValidator.class})
@SpringBootTest(classes = MoneyTransferApplication.class)
public class TransferTransactionValidatorsTest {

    @Autowired
    private Validator validator;

    @Test
    public void checkCurrencyCodeValidator() {
        PowerMockito.mockStatic(CurrencyCodeValidator.class);

        PowerMockito.when(CurrencyCodeValidator.getValidCurrencies())
                .thenReturn(Collections.singletonList("EUR"));

        TransferTransaction transferTransaction = new TransferTransaction()
                .setBankOfRecipient("CB")
                .setTransactionAmount(new BigDecimal("100"))
                .setTransactionCurrency("USD");

        Set<ConstraintViolation<TransferTransaction>> violations = validator.validate(transferTransaction);

        assertEquals(1, violations.size());
    }

    @Test
    public void checkBankCodeValidator() throws Exception {
        BankCodeValidator spy = Mockito.spy(new BankCodeValidator());

        PowerMockito.when(spy, "getValidBanks")
                .thenReturn(Collections.singletonList("HSBC"));

        TransferTransaction transferTransaction = new TransferTransaction()
                .setBankOfRecipient("CB")
                .setTransactionAmount(new BigDecimal("100"))
                .setTransactionCurrency("USD");

        assertFalse(spy.isValid(transferTransaction.getBankOfRecipient()));
    }
}