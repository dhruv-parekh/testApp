package com.example.testApp.Validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD,  ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidCreatedByValidator.class)
@Documented
public @interface ValidCreatedBy {
    String message() default "Invalid Name";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}