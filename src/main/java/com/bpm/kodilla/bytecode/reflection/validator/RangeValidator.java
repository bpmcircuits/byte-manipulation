package com.bpm.kodilla.bytecode.reflection.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RangeValidator implements ConstraintValidator<Range, Integer> {

    private Integer minAnnotationValue;
    private Integer maxAnnotationValue;

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return minAnnotationValue <= value && value <= maxAnnotationValue;
    }

    @Override
    public void initialize(Range constraintAnnotation) {
        minAnnotationValue = constraintAnnotation.min();
        maxAnnotationValue = constraintAnnotation.max();
    }
}
