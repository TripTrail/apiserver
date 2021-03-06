package com.company.application.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.NotNull;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = EnumValidatorImpl.class)
@NotNull(message = "Value cannot be null")
@ReportAsSingleViolation
public @interface EnumValidator {
    Class<? extends Enum<?>> enumClass();

    String message() default "Value is not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}