package com.epam.upskill.calculator.models.operations;

import com.epam.upskill.calculator.exceptionHandler.NullArgument;
import com.epam.upskill.calculator.models.Result;

public class MultiplyOperation extends OperationAbstract{

	@Override
	public Result perform() throws NullArgument {
		Result result = operandsValidator();
		if (!result.getError()) {
			result.setResult(operand1.multiply(operand2));
			result.setError(Boolean.FALSE);
		}
		return result;
	}

	@Override
	public String toString() {
		return super.toString("Multiply ");
	}

}
