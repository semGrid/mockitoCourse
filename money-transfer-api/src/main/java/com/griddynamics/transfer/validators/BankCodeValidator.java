package com.griddynamics.transfer.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.Collection;

public class BankCodeValidator implements ConstraintValidator<ValidBank, String> {

    @Override
    public void initialize(ValidBank constraintAnnotation) {
    }

    @Override
    public boolean isValid(String bankCode, ConstraintValidatorContext constraintValidatorContext) {
        return getValidBanks().contains(bankCode);
    }

    private Collection<String> getValidBanks() {
        return Arrays.asList("CB", "HSBC", "MLM", "PRIV", "VTB");
    }
}