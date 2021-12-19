package com.example.RamirezRamosAlejandro_TrianaTouristApp.validation.validators;

import com.example.RamirezRamosAlejandro_TrianaTouristApp.validation.anotations.Url;
import org.springframework.beans.PropertyAccessorFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UrlValidator implements ConstraintValidator<Url, Object> {

    private String url;

    @Override
    public void initialize(Url constraintAnnotation) {
        this.url = constraintAnnotation.url();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        String url = (String) PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(this.url);

        if(url.startsWith("http")){
            return true;
        } else {
            return false;
        }
    }
}
