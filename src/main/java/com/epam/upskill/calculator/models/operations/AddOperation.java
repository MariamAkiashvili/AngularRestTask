package com.epam.upskill.calculator.models.operations;

import com.epam.upskill.calculator.exceptionHandler.NullArgument;
import com.epam.upskill.calculator.models.Result;

public class AddOperation extends OperationAbstract {


	/**
	 * The AddOperation class extends the OperationAbstract class and provides the implementation
	 * for performing addition operations.
	 * <p>
	 * At first, it validates the operands using the operandsValidator method from the
	 * OperationAbstract class to check if even one of them is null. If the operands are valid,
	 * it performs the addition of operand1 and
	 * operand2, and stores the result in a Result object. It also sets the error flag to false if
	 * the operation is successful and operands are valid.
	 * In case of invalid operands (e.g., null values), a NullArgument
	 * exception is thrown.
	 * <p>
	 * The toString method overrides the method from OperationAbstract to return a string
	 * representation of the addition operation, prefixed with "Add ".
	 */


	@Override
	public Result perform() throws NullArgument {
		Result result = operandsValidator();
		if (!result.getError()) {
			result.setResult(operand1.add(operand2));
			result.setError(Boolean.FALSE);
		}
		return result;
	}

	@Override
	public String toString() {
		return super.toString("Add ");
	}
}
