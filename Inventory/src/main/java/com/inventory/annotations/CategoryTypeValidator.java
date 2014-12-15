package com.inventory.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class CategoryTypeValidator implements ConstraintValidator<CategoryType, String> {

	@Override
	public void initialize(CategoryType arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String in, ConstraintValidatorContext arg1) {
		 if(in == null) {
			             return false;
			         }
			         return in.toUpperCase().matches("ROCK")||in.toUpperCase().matches("COUNTRY")||in.toUpperCase().matches("FUNK");

	}



}
