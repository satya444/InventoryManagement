package com.inventory.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TestThisValidator implements ConstraintValidator<TestThis, String> {

	@Override
	public void initialize(TestThis arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String in, ConstraintValidatorContext arg1) {
		 if(in == null) {
			             return false;
			         }
			         return in.matches("[a,b,c]");

	}

}
