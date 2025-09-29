package com.bpm.kodilla.bytecode.reflection.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RangeValidator.class)
public @interface Range {

    String message() default "Value is not in range";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    int min();
    int max();
}
