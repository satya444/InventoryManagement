package com.inventory.annotations;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = CategoryTypeValidator.class)
@Target( {METHOD, FIELD })
@Retention(RUNTIME)
public @interface CategoryType {
	String message() default "Enter either Country or Rock or Funk ";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
