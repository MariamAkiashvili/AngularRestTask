package com.epam.upskill.calculator.models.operations;

import com.epam.upskill.calculator.exceptionHandler.NullArgument;
import com.epam.upskill.calculator.models.Result;

import java.math.BigDecimal;

public class SubtractOperation extends OperationAbstract {

	/**
	 * The SubtractOperation class extends the OperationAbstract class and provides the implementation
	 * for performing subtraction operations.
	 * <p>
	 * At first, it validates the operands using the operandsValidator method from the
	 * OperationAbstract class. It initializes the result to BigDecimal.ZERO. If the operands are valid,
	 * it performs the subtraction of operand2 from operand1 and stores the result in a Result object.
	 * It also sets the error flag to false if the operation is successful and operands are valid.
	 * In case of invalid operands
	 * (e.g., null values), an appropriate exception (NullArgument) is thrown.
	 * <p>
	 * The toString method overrides the method from OperationAbstract to return a string
	 * representation of the subtraction operation, prefixed with "Subtract ".
	 */


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
