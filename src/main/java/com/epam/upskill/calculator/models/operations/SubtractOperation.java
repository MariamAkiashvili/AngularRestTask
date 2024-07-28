package com.epam.upskill.calculator.models.operations;

import com.epam.upskill.calculator.exceptionHandler.NullArgument;
import com.epam.upskill.calculator.models.Result;

import java.math.BigDecimal;

public class SubtractOperation extends OperationAbstract {

	@Override
	public Result perform() throws NullArgument {
		Result result = operandsValidator();
		result.setResult(BigDecimal.ZERO);
		if(!result.getError()){
			result.setResult(operand1.subtract(operand2));
			result.setError(Boolean.FALSE);
		}
		return result;
	}
	
	@Override
	public String toString() {
		return super.toString("Subtract ");
	}

}
