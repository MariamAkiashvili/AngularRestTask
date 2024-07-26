package com.epam.upskill.calculator;

import com.epam.upskill.calculator.models.Result;
import com.epam.upskill.calculator.models.operations.AddOperation;
import com.epam.upskill.calculator.models.operations.DivideOperation;
import com.epam.upskill.calculator.models.operations.MultiplyOperation;
import com.epam.upskill.calculator.models.operations.SubtractOperation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorOperationTest {

    @Mock
    private Result mockResult;

    @Spy
    @InjectMocks
    private AddOperation addOperation;

    @Spy
    @InjectMocks
    private SubtractOperation subtractOperation;

    @Spy
    @InjectMocks
    private MultiplyOperation multiplyOperation;

    @Spy
    @InjectMocks
    private DivideOperation divideOperation;


    // Test for AddOperations
    @Test
    public void AddTwoPositiveNumberTest() throws Exception {
        BigDecimal operand1 = new BigDecimal("10");
        BigDecimal operand2 = new BigDecimal("15");
        addOperation.setOperand1(operand1);
        addOperation.setOperand2(operand2);

        Result result = addOperation.perform();

//        System.out.println("Expected : 25");
//        System.out.println("Actual: "+result.getResult());
        assertFalse(result.getError());
        assertEquals(new BigDecimal("25"), result.getResult());
    }

    @Test
    public void AddNullOperatorTest() throws Exception {

        BigDecimal operand2 = new BigDecimal("15");
        addOperation.setOperand1(null);
        addOperation.setOperand2(operand2);

        Result result = addOperation.perform();

        assertTrue(result.getError());
    }

    @Test
    public void AddTwoNegativeNumber() throws Exception {
        BigDecimal operand1 = new BigDecimal("-10");
        BigDecimal operand2 = new BigDecimal("-15");
        addOperation.setOperand1(operand1);
        addOperation.setOperand2(operand2);

        Result result = addOperation.perform();

//        System.out.println("Expected : -25");
//        System.out.println("Actual: "+result.getResult());
        assertFalse(result.getError());
        assertEquals(new BigDecimal("-25"), result.getResult());
    }


    // Tests for SubtractOperations
    @Test
    public void SubtractNullOperatorTest() throws Exception {
        BigDecimal operand1 = new BigDecimal("10");

        subtractOperation.setOperand1(operand1);
        subtractOperation.setOperand2(null);

        Result result = subtractOperation.perform();

        assertTrue(result.getError());
    }

    @Test
    public void SubtractTwoPositiveNumberTest() throws Exception {
        BigDecimal operand1 = new BigDecimal("10");
        BigDecimal operand2 = new BigDecimal("15");
        subtractOperation.setOperand1(operand1);
        subtractOperation.setOperand2(operand2);

        Result result = subtractOperation.perform();

//        System.out.println("Expected : -5");
//        System.out.println("Actual: "+result.getResult());
        assertFalse(result.getError());
        assertEquals(new BigDecimal("-5"), result.getResult());
    }

    @Test
    public void SubtractNegativeNumbersTest() throws Exception {
        BigDecimal operand1 = new BigDecimal("-10");
        BigDecimal operand2 = new BigDecimal("-15");
        subtractOperation.setOperand1(operand1);
        subtractOperation.setOperand2(operand2);

        Result result = subtractOperation.perform();

//        System.out.println("Expected : 5");
//        System.out.println("Actual: "+result.getResult());
        assertFalse(result.getError());
        assertEquals(new BigDecimal("5"), result.getResult());
    }

    @Test
    public void SubtractZeroTest() throws Exception {
        BigDecimal operand1 = new BigDecimal("10");
        BigDecimal operand2 = new BigDecimal("0");
        subtractOperation.setOperand1(operand1);
        subtractOperation.setOperand2(operand2);

        Result result = subtractOperation.perform();

//        System.out.println("Expected : 10");
//        System.out.println("Actual: "+result.getResult());
        assertFalse(result.getError());
        assertEquals(new BigDecimal("10"), result.getResult());
    }


    //Tests for MultiplyOperations
    @Test
    public void MultiplyNullOperatorTest() throws Exception {
        BigDecimal operand1 = new BigDecimal("10");

        multiplyOperation.setOperand1(operand1);
        multiplyOperation.setOperand2(null);

        Result result = multiplyOperation.perform();

        assertTrue(result.getError());
    }

    @Test
    public void MultiplyTwoPositiveNumberTest() throws Exception {
        BigDecimal operand1 = new BigDecimal("10");
        BigDecimal operand2 = new BigDecimal("15");
        multiplyOperation.setOperand1(operand1);
        multiplyOperation.setOperand2(operand2);

        Result result = multiplyOperation.perform();

//        System.out.println("Expected : 150");
//        System.out.println("Actual: "+result.getResult());
        assertFalse(result.getError());
        assertEquals(new BigDecimal("150"), result.getResult());
    }

    @Test
    public void MultiplyTwoNegativeNumbersTest() throws Exception {
        BigDecimal operand1 = new BigDecimal("-10");
        BigDecimal operand2 = new BigDecimal("-15");
        multiplyOperation.setOperand1(operand1);
        multiplyOperation.setOperand2(operand2);

        Result result = multiplyOperation.perform();

//        System.out.println("Expected : 5");
//        System.out.println("Actual: "+result.getResult());
        assertFalse(result.getError());
        assertEquals(new BigDecimal("150"), result.getResult());
    }

    @Test
    public void MultiplyOneNegativeOperatorTest() throws Exception {
        BigDecimal operand1 = new BigDecimal("10");
        BigDecimal operand2 = new BigDecimal("-5");
        multiplyOperation.setOperand1(operand1);
        multiplyOperation.setOperand2(operand2);

        Result result = multiplyOperation.perform();

//        System.out.println("Expected : -50");
//        System.out.println("Actual: "+result.getResult());
        assertFalse(result.getError());
        assertEquals(new BigDecimal("-50"), result.getResult());
    }

    @Test
    public void MultiplyByZeroTest() throws Exception {
        BigDecimal operand1 = new BigDecimal("10");
        BigDecimal operand2 = new BigDecimal("0");
        multiplyOperation.setOperand1(operand1);
        multiplyOperation.setOperand2(operand2);

        Result result = multiplyOperation.perform();

//        System.out.println("Expected : 0");
//        System.out.println("Actual: "+result.getResult());
        assertFalse(result.getError());
        assertEquals(new BigDecimal("0"), result.getResult());
    }


    //Tests for DivideOperations
    @Test
    public void DivideNullOperatorTest() throws Exception {
        BigDecimal operand1 = new BigDecimal("10");

        divideOperation.setOperand1(operand1);
        divideOperation.setOperand2(null);

        Result result = divideOperation.perform();

        assertTrue(result.getError());
    }

    @Test
    public void DivideTwoPositiveNumberTest() throws Exception {
        BigDecimal operand1 = new BigDecimal("10");
        BigDecimal operand2 = new BigDecimal("5");
        divideOperation.setOperand1(operand1);
        divideOperation.setOperand2(operand2);

        Result result = divideOperation.perform();

//        System.out.println("Expected : 2");
//        System.out.println("Actual: "+result.getResult());
        assertFalse(result.getError());
        assertEquals(new BigDecimal("2"), result.getResult());
    }

    @Test
    public void DivideTwoNegativeNumbersTest() throws Exception {
        BigDecimal operand1 = new BigDecimal("-10");
        BigDecimal operand2 = new BigDecimal("-5");
        divideOperation.setOperand1(operand1);
        divideOperation.setOperand2(operand2);

        Result result = divideOperation.perform();

//        System.out.println("Expected : 2");
//        System.out.println("Actual: "+result.getResult());
        assertFalse(result.getError());
        assertEquals(new BigDecimal("2"), result.getResult());
    }

    @Test
    public void DivideOneNegativeOperatorTest() throws Exception {
        BigDecimal operand1 = new BigDecimal("10");
        BigDecimal operand2 = new BigDecimal("-5");
        divideOperation.setOperand1(operand1);
        divideOperation.setOperand2(operand2);

        Result result = divideOperation.perform();

//        System.out.println("Expected : -2");
//        System.out.println("Actual: "+result.getResult());
        assertFalse(result.getError());
        assertEquals(new BigDecimal("-2"), result.getResult());
    }

    @Test
    public void DivideByZeroTest() throws Exception {
        BigDecimal operand1 = new BigDecimal("10");
        BigDecimal operand2 = new BigDecimal("0");
        divideOperation.setOperand1(operand1);
        divideOperation.setOperand2(operand2);

        Result result = divideOperation.perform();

        assertTrue(result.getError());
        assertEquals("Error: Can't divide by zero", result.getMessage());
    }

}
