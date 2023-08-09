package com.example.testApp.Validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD,  ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidWebsiteValidator.class)
@Documented
public @interface ValidWebsite {

    String message() default "Invalid Website";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
