package com.griddynamics.transfer.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.Collection;

public class CurrencyCodeValidator implements ConstraintValidator<ValidCurrency, String> {

    @Override
    public void initialize(ValidCurrency constraintAnnotation) {

    }

    @Override
    public boolean isValid(String currencyCode, ConstraintValidatorContext constraintValidatorContext) {
        return getValidCurrencies().contains(currencyCode);
    }

    public static Collection<String> getValidCurrencies() {
        return Arrays.asList("USD", "EUR", "PLN", "UAH", "RUB");
    }
}
