package com.example.testApp.Validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidWebsiteValidator implements ConstraintValidator<ValidWebsite,String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s.startsWith("http://") || s.startsWith("https://")){
            return  true;
        }
        else return false;
    }
}
