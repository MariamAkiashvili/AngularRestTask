package com.epam.upskill.calculator.models.operations;

import com.epam.upskill.calculator.ErrorCode.ErrorCode;
import com.epam.upskill.calculator.models.Result;
import com.epam.upskill.calculator.util.Constants;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DivideOperation extends OperationAbstract {

	private final BigDecimal ZERO = new BigDecimal(0);

	/**
	 * The DivideOperation class extends the OperationAbstract class and provides the implementation
	 * for performing division operations.

	 * The perform method validates the operands using the operandsValidator method from the
	 * OperationAbstract class. If the operands are valid, it checks if the second operand (operand2)
	 * is zero. If operand2 is zero, it sets an error flag, provides an error message indicating that
	 * division by zero is not allowed, and logs the error. Otherwise, it performs the division of
	 * operand1 by operand2 with a precision of 10 decimal places and stores the result in a Result object.
	 * It also sets the error flag to false if the operation is successful and both operands are valid.
	 * In case of invalid operands
	 * (e.g., null values), appropriate exceptions (NullArgument, IllegalArgument) are thrown.

	 * The toString method overrides the method from OperationAbstract to return a string
	 * representation of the division operation, prefixed with "Divide ".
	 * @return the Result
	 */


	@Override
	public Result perform() {
		Result result = operandsValidator();
		if (!result.getError()) {
			if(operand2.compareTo(ZERO) == 0) {
				result.setError(Boolean.TRUE);
				result.setMessage(Constants.ERROR_MESSAGE_DIVIDE_BY_ZERO);
				getLogger().error("Can't divide by Zero");
				result.setErrorCode(ErrorCode.INVALID_ARGUMENT);
			}
			else {
				result.setResult(operand1.divide(operand2, 10, RoundingMode.CEILING));
				result.setError(Boolean.FALSE);
				result.setErrorCode(ErrorCode.SUCCESSFUL_OPERATION);
			}
		}else {
			result.setErrorCode(ErrorCode.INVALID_ARGUMENT);
		}

		return result;
	}

	/**
	 *
	 * @return the operation name
	 */
	@Override
	public String toString() {
		return super.toString("Divide ");
	}

}
