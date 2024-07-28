package com.epam.upskill.calculator.models.operations;

import com.epam.upskill.calculator.exceptionHandler.NullArgument;
import com.epam.upskill.calculator.models.Result;

public class MultiplyOperation extends OperationAbstract{

	/**
	 * The MultiplyOperation class extends the OperationAbstract class and provides the implementation
	 * for performing multiplication operations.
	 * <p>
	 * The perform method validates the operands using the operandsValidator method from the
	 * OperationAbstract class. If both operands are valid, it performs the multiplication of operand1
	 * and operand2, and stores the result in a Result object. It also sets the error flag to false if
	 * the operation is successful and operands are valid.
	 * In case of invalid operands (e.g., null values), an appropriate
	 * exception (NullArgument) is thrown.
	 * <p>
	 * The toString method overrides the method from OperationAbstract to return a string
	 * representation of the multiplication operation, prefixed with "Multiply ".
	 */

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
