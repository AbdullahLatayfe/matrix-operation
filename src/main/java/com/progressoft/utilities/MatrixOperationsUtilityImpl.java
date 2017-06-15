package com.progressoft.utilities;

/**
 * Created by Abdullah on 6/14/2017.
 */
public class MatrixOperationsUtilityImpl implements MatrixOperationsUtility {

    @Override
    public int[][] add(int[][] a, int[][] b) throws IncompatibleArgumentsException {
        int[][] newArray;
        newArray = new int[a.length][b[0].length];
        validateCheckSizeOfArray(a, b);
        for (int rows = 0; rows < a.length; rows++)
            for (int column = 0; column < a[rows].length; column++)
                newArray[rows][column] = a[rows][column] + b[rows][column];
        return newArray;
    }

    @Override
    public int[][] scalarMultiply(int scalar, int[][] a) {
        for (int rows = 0; rows < a.length; rows++)
            for (int column = 0; column < a[0].length; column++)
                a[rows][column] = scalar * a[rows][column];
        return a;
    }

    @Override
    public int[][] transport(int[][] a) {
        int[][] result;
        result = new int[a[0].length][a.length];

        for (int rows = 0; rows < a.length; rows++)
            for (int column = 0; column < a[rows].length; column++)
                result[column][rows] = a[rows][column];


        return result;
    }

    @Override
    public int[][] multiply(int[][] a, int[][] b) throws IncompatibleArgumentsException {
        int[][] result;
        int sum = 0;
        validateMultiplyCheckSize(a, b);
        result = new int[a.length][a.length];
        for (int rows = 0; rows < a.length; rows++) {
            for (int rowsSec = 0; rowsSec < a.length; rowsSec++) {
                for (int column = 0; column < b.length; column++) {
                    sum = sum + a[rows][column] * b[column][rowsSec];
                }
                result[rows][rowsSec] = sum;
                sum = 0;
            }
        }
        return result;
    }

    private void validateCheckSizeOfArray(int[][] a, int[][] b) throws IncompatibleArgumentsException {
        if (a.length != b.length) {
            throw new IncompatibleArgumentsException("The rows are not same size");
        } else {
            for (int index = 0; index < a.length; index++) {
                if (a[index].length != b[index].length) {
                    throw new IncompatibleArgumentsException("The column are not same size");
                }
            }
        }
    }


    private void validateMultiplyCheckSize(int[][] a, int[][] b) throws IncompatibleArgumentsException {
        if (a.length == 0 || b.length == 0) {
            throw new IncompatibleArgumentsException("The size is 0");
        }

        for (int index = 0; index < a.length; index++) {
            if (a[index].length == b.length) {
                for (int index2 = 0; index2 < b.length; index2++) {
                    if (b[index2].length != a.length) {
                        throw new IncompatibleArgumentsException("Number of rows not equal number of column in first Array");
                    }
                }
            } else {
                throw new IncompatibleArgumentsException("Number of column not equal number of rows in first Array");
            }
        }
    }

}
