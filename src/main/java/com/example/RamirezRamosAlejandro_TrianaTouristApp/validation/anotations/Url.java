package com.example.RamirezRamosAlejandro_TrianaTouristApp.validation.anotations;

import com.example.RamirezRamosAlejandro_TrianaTouristApp.validation.validators.UrlValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = UrlValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Url {

    String message() default "Debe ser una URL";

    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};

    String url();

    @Target({ ElementType.TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        Url[] value();
    }
}
