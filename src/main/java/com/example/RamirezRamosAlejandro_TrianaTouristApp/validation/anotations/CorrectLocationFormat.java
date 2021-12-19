package com.example.RamirezRamosAlejandro_TrianaTouristApp.validation.anotations;

import com.example.RamirezRamosAlejandro_TrianaTouristApp.validation.validators.CorrectLocationFormatValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CorrectLocationFormatValidator.class)
@Documented
public @interface CorrectLocationFormat {

    String message() default "Esa localización no es válida.";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
