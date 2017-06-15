package com.progressoft.utilities;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public class MatrixOperationsUtilityTest {

	private MatrixOperationsUtility matrixOperationsUtility;

	@Before
	public void setup() {

		// dummy implementation, to be replaced
		matrixOperationsUtility = new MatrixOperationsUtilityImpl();
	}

	@Test
	public void givenMathematicalMatrixOperationsModel_CallingAddMethod_PassingSameSizeMatrices_Case1_ShouldReutrnTheExpectedResults() {
		int firstMatrix[][] = { { 1, 4, 7 } };
		int secondMatrix[][] = { { 9, 6, 3 } };
		int expectedResults[][] = { { 10, 10, 10 } };
		assertResultsAreEquals(expectedResults, matrixOperationsUtility.add(firstMatrix, secondMatrix));
	}

	@Test
	public void givenMathematicalMatrixOperationsModel_CallingAddMethod_PassingSameSizeMatrices_Case2_ShouldReutrnTheExpectedResults() {
		int firstMatrix[][] = { { 1 }, { 4 }, { 7 } };
		int secondMatrix[][] = { { 9 }, { 6 }, { 3 } };
		int expectedResults[][] = { { 10 }, { 10 }, { 10 } };
		int returnedResults[][] = matrixOperationsUtility.add(firstMatrix, secondMatrix);
		assertResultsAreEquals(expectedResults, returnedResults);
	}

	@Test(expected = IncompatibleArgumentsException.class)
	public void givenMathematicalMatrixOperationsModel_CallingAddMethod_PassingNonEqualsSizesMatrices_ShouldThrowIncompatibleArguments() {
		int firstMatrix[][] = new int[1][3];
		int secondMatrix[][] = new int[3][3];
		matrixOperationsUtility.add(firstMatrix, secondMatrix);
	}

	@Test
	public void givenMathematicalMatrixOperationsModel_CallingScalarMultiply_PassingValidMatrix_ShouldReutrnTheExpectedResults() {
		int matrix[][] = { { 1, 2, 3 } };
		int scaler = 2;
		int expectedResults[][] = { { 2, 4, 6 } };
		assertResultsAreEquals(expectedResults, matrixOperationsUtility.scalarMultiply(scaler, matrix));
	}

	@Test
	public void givenMathematicalMatrixOperationsModel_CallingScalarMultiply_PassingZeroSizeMatrix_ShouldReutrnTheExpectedResults() {
		int matrix[][] = new int[0][0];
		int scaler = 2;
		int expectedResults[][] = new int[0][0];
		assertResultsAreEquals(expectedResults, matrixOperationsUtility.scalarMultiply(scaler, matrix));
	}

	@Test(expected = Exception.class)
	public void givenMathematicalMatrixOperationsModel_CallingTranport_PassingNullMatrix_ShouldThrowAnException() {
		matrixOperationsUtility.transport(null);
	}

	@Test
	public void givenMathematicalMatrixOperationsModel_CallingTranport_PassingValidMatrix_Case1_ShouldReutrnTheExpectedResults() {
		int matrix[][] = { { 1 } };
		int expectedResults[][] = { { 1 } };
		assertResultsAreEquals(expectedResults, matrixOperationsUtility.transport(matrix));
	}

	@Test
	public void givenMathematicalMatrixOperationsModel_CallingTranport_PassingValidMatrix_Case2_ShouldReutrnTheExpectedResults() {
		int matrix[][] = { { 1, 2, 3 }, { 1, 2, 3 } };
		int expectedResults[][] = { { 1, 1 }, { 2, 2 }, { 3, 3 } };
		assertResultsAreEquals(expectedResults, matrixOperationsUtility.transport(matrix));
	}

	@Test(expected = Exception.class)
	public void givenMatheMaticalMatrixOperationsMoldel_CallingMultiply_PassingFirstMatrixWithDifferentRowsLengths_ShouldThrowAnException() {
		int firstMatrix[][] = { { 1, 2 }, { 1, 2, 3 } };
		int secondMatrix[][] = new int[2][2];
		matrixOperationsUtility.multiply(firstMatrix, secondMatrix);
	}

	@Test(expected = IncompatibleArgumentsException.class)
	public void givenMatheMaticalMatrixOperationsMoldel_CallingMultiply_PassingFirstMatrixWithZeroRows_ShouldThrowIncompatibleArguments() {
		int firstMatrix[][] = new int[0][1];
		int secondMatrix[][] = new int[2][2];
		matrixOperationsUtility.multiply(firstMatrix, secondMatrix);
	}

	@Test
	public void givenMatheMaticalMatrixOperationsMoldel_CallingMultiply_PassingValidMatrices_ShouldReturnTheExpectedResult() {
		int firstMatrix[][] = { { 1, 2, 3 }, { 1, 2, 3 } };
		int secondMatrix[][] = { { 3, 3 }, { 2, 2 }, { 1, 1 } };
		int expectedResult[][] = { { 10, 10 }, { 10, 10 } };
		assertResultsAreEquals(expectedResult, matrixOperationsUtility.multiply(firstMatrix, secondMatrix));
	}

	@Test(expected = Exception.class)
	public void givenMatheMaticalMatrixOperationsMoldel_CallingMultiply_PassingSecondMatrixWithDifferentRowsLengths_ShouldThrowAnException() {
		int firstMatrix[][] = new int[2][2];
		int secondMatrix[][] = { { 1, 2 }, { 1, 2, 3 } };
		matrixOperationsUtility.multiply(firstMatrix, secondMatrix);
	}

	@Test (expected =  IncompatibleArgumentsException.class)
	public void givenMathematicalMatrixOperationsModel_CallingAddMethod_PassingColumnNonEqualsSizesMatrices_ThrowIncompatibleArgumentsException() {
		int firstMatrix[][] = new int[2][2];
		int secondMatrix[][] = new int[2][1];
		matrixOperationsUtility.add(firstMatrix,secondMatrix);
	}

	private void assertResultsAreEquals(int[][] expectedResults, int[][] returnedResults) {
		assertEquals(expectedResults.length, returnedResults.length);
		for (int i = 0; i < expectedResults.length; ++i) {
			assertArrayEquals(expectedResults[i], returnedResults[i]);
		}
	}
}
