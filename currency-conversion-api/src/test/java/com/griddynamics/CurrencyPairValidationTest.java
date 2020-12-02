package com.griddynamics;

import com.griddynamics.conversion.CurrencyConversionApplication;
import com.griddynamics.conversion.entities.CurrencyConversionRate;
import com.griddynamics.conversion.entities.CurrencyId;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

//TODO: assignment: add all annotations required for PowerMock configuration

@SpringBootTest(classes = CurrencyConversionApplication.class)
public class CurrencyPairValidationTest {

    @Autowired
    private Validator validator;

    @Test
    public void checkCurrencyPairValidator() {

        //TODO: assignment: mock private static method of com.griddynamics.conversion.validators.CurrencyIdValidator.getValid()

        //TODO: assignment: use this code for verification of mock
        Set<ConstraintViolation<CurrencyConversionRate>> violations =
                validator.validate(new CurrencyConversionRate()
                .setCurrency(new CurrencyId("EUR", "EUR")));

        assertEquals(1, violations.size());
    }

}