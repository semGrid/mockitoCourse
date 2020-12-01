package com.griddynamics.transfer.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BankCodeValidator.class)
public @interface ValidBank {

    String message() default "Invalid bank";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
