package com.griddynamics.conversion.validators;

import com.griddynamics.conversion.entities.CurrencyId;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.Collection;

public class CurrencyIdValidator implements ConstraintValidator<ValidCurrencyId, CurrencyId> {


    @Override
    public void initialize(ValidCurrencyId constraintAnnotation) {
        //init
    }

    @Override
    public boolean isValid(CurrencyId currencyId, ConstraintValidatorContext constraintValidatorContext) {
        return getValid().contains(currencyId);
    }

    //Method for PowerMockito usage example
    private static Collection<CurrencyId> getValid() {
        return Arrays
                .asList(
                        new CurrencyId("EUR", "USD"),
                        new CurrencyId("EUR", "EUR"),
                        new CurrencyId("USD", "USD"),
                        new CurrencyId("EUR", "RUB"),
                        new CurrencyId("EUR", "PLN"),
                        new CurrencyId("EUR", "UAH"),
                        new CurrencyId("USD", "EUR"),
                        new CurrencyId("USD", "RUB"),
                        new CurrencyId("USD", "PLN"),
                        new CurrencyId("USD", "UAH"),
                        new CurrencyId("PLN", "EUR"),
                        new CurrencyId("PLN", "PLN"),
                        new CurrencyId("PLN", "RUB"),
                        new CurrencyId("PLN", "USD"),
                        new CurrencyId("PLN", "UAH"),
                        new CurrencyId("UAH", "UAH"),
                        new CurrencyId("UAH", "EUR"),
                        new CurrencyId("UAH", "RUB"),
                        new CurrencyId("UAH", "USD"),
                        new CurrencyId("UAH", "PLN"),
                        new CurrencyId("RUB", "RUB"),
                        new CurrencyId("RUB", "EUR"),
                        new CurrencyId("RUB", "UAH"),
                        new CurrencyId("RUB", "USD"),
                        new CurrencyId("RUB", "PLN")
                );
    }
}
