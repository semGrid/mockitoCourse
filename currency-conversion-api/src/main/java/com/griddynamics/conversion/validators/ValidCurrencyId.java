package com.griddynamics.conversion.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CurrencyIdValidator.class)
public @interface ValidCurrencyId {

    String message() default "Invalid currency pair";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
