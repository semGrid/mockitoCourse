package com.griddynamics;

import com.griddynamics.conversion.CurrencyConversionApplication;
import com.griddynamics.conversion.entities.CurrencyConversionRate;
import com.griddynamics.conversion.entities.CurrencyId;
import com.griddynamics.conversion.validators.CurrencyIdValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
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
import java.util.Collections;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(SpringJUnit4ClassRunner.class)
@PowerMockIgnore("javax.management.*")
@PrepareForTest(value = {CurrencyIdValidator.class})
@SpringBootTest(classes = CurrencyConversionApplication.class)
public class CurrencyValidationTest {

    @Autowired
    private Validator validator;

    @Test
    public void checkCurrencyPairValidator() throws Exception {

        PowerMockito.mockStatic(CurrencyIdValidator.class);

        PowerMockito.when(CurrencyIdValidator.class, "getValid")
                .thenReturn(Collections.singletonList(new CurrencyId("EUR", "USD")));

        Set<ConstraintViolation<CurrencyConversionRate>> violations =
                validator.validate(new CurrencyConversionRate()
                .setCurrency(new CurrencyId("EUR", "EUR")));

        assertEquals(1, violations.size());
    }

}