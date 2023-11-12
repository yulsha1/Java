package org.example;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.SingularMatrixException;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class Matrix implements IMatrix {
    private int[][] matrix;

    public Matrix() {
        matrix = new int[0][0];
    }

    public Matrix(int rows, int columns) {
        matrix = new int[rows][columns];
    }

    public Matrix(IMatrix matrixToCopy) {
        int rows = matrixToCopy.getRows();
        int columns = matrixToCopy.getColumns();
        matrix = new int[rows][columns];

        int[][] sourceMatrix = matrixToCopy.getMatrix();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = sourceMatrix[i][j];
            }
        }
    }
    public Matrix(int[][] matrix){
        this.matrix=matrix;
    }
    public int getRows() {
        return matrix.length;
    }

    public int getColumns() {
        return matrix[0].length;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void fillFullMatrix() {
        Scanner scanner = new Scanner(System.in);
        int rows = getRows();
        int columns = getColumns();

        System.out.println("Please enter the values for the matrix:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Enter the value for row " + (i + 1) + ", column " + (j + 1) + ": ");
                if (scanner.hasNextInt()) {
                    matrix[i][j] = scanner.nextInt();
                } else {
                    System.out.println("Invalid input. Please enter an integer.");
                    scanner.nextLine();
                    j--;
                }
            }
        }
    }

    public int getElement(int row, int column) {
        if (isValidIndex(row, column)) {
            return matrix[row][column];
        } else {
            throw new IllegalArgumentException("Invalid row or column index.");
        }
    }

    public int[] getRow(int row) {
        if (isValidRowIndex(row)) {
            return matrix[row].clone();
        } else {
            throw new IllegalArgumentException("Invalid row index.");
        }
    }

    public int[] getColumn(int column) {
        if (isValidColumnIndex(column)) {
            int[] result = new int[getRows()];
            for (int i = 0; i < getRows(); i++) {
                result[i] = matrix[i][column];
            }
            return result;
        } else {
            throw new IllegalArgumentException("Invalid column index!");
        }
    }

    private boolean isValidIndex(int row, int column) {
        return isValidRowIndex(row) && isValidColumnIndex(column);
    }

    private boolean isValidRowIndex(int row) {
        return row >= 0 && row < getRows();
    }

    private boolean isValidColumnIndex(int column) {
        return column >= 0 && column < getColumns();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix other = (Matrix) o;
        return Arrays.deepEquals(matrix, other.matrix);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(matrix);
    }
    public void fillRandomMatrix(int minRandomValue, int maxRandomValue) {
        int rows = getRows();
        int columns = getColumns();
        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int randomValue = random.nextInt(maxRandomValue - minRandomValue + 1) + minRandomValue;
                matrix[i][j] = randomValue;
            }
        }
    }
    public ImmutableMatrix add(IMatrix otherMatrix) {
        int rows = getRows();
        int columns = getColumns();

        if (rows != otherMatrix.getRows() || columns != otherMatrix.getColumns()) {
            throw new IllegalArgumentException("Matrices must have the same dimensions for addition.");
        }

        ImmutableMatrix resultMatrix = new ImmutableMatrix(rows, columns);
        int[][] result = resultMatrix.getMatrix();
        int[][] other = otherMatrix.getMatrix();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = matrix[i][j] + other[i][j];
            }
        }

        return resultMatrix;
    }

    public ImmutableMatrix multiply(int scalar) {
        int rows = getRows();
        int columns = getColumns();

        ImmutableMatrix resultMatrix = new ImmutableMatrix(rows, columns);
        int[][] result = resultMatrix.getMatrix();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = matrix[i][j] * scalar;
            }
        }

        return resultMatrix;
    }

    public ImmutableMatrix multiply(IMatrix otherMatrix) {
        int rowsA = getRows();
        int columnsA = getColumns();
        int rowsB = otherMatrix.getRows();
        int columnsB = otherMatrix.getColumns();

        if (columnsA != rowsB) {
            throw new IllegalArgumentException("The number of columns in the first matrix must be equal to the number of rows in the second matrix for matrix multiplication.");
        }

        ImmutableMatrix resultMatrix = new ImmutableMatrix(rowsA, columnsB);
        int[][] result = resultMatrix.getMatrix();
        int[][] other = otherMatrix.getMatrix();

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < columnsB; j++) {
                for (int k = 0; k < columnsA; k++) {
                    result[i][j] += matrix[i][k] * other[k][j];
                }
            }
        }

        return resultMatrix;
    }
    public ImmutableMatrix inverse() {
        int size = getRows();

        if (size != getColumns()) {
            throw new IllegalArgumentException("Matrix must be square to find its inverse.");
        }

        double[][] augmentedMatrix = new double[size][2 * size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                augmentedMatrix[i][j] = matrix[i][j];
                augmentedMatrix[i][size + j] = (i == j) ? 1.0 : 0.0;
            }
        }

        for (int i = 0; i < size; i++) {
            double pivot = augmentedMatrix[i][i];

            for (int j = 0; j < 2 * size; j++) {
                augmentedMatrix[i][j] /= pivot;
            }

            for (int k = 0; k < size; k++) {
                if (k != i) {
                    double factor = augmentedMatrix[k][i];
                    for (int j = 0; j < 2 * size; j++) {
                        augmentedMatrix[k][j] -= factor * augmentedMatrix[i][j];
                    }
                }
            }
        }

        int[][] inverseMatrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                inverseMatrix[i][j] = (int) Math.round(augmentedMatrix[i][size + j]);
                //System.out.print(augmentedMatrix[i][size + j]+" ");
            }
           // System.out.println();
        }

        return new ImmutableMatrix(inverseMatrix);
    }


    public double[][] convertToIntToDouble(int[][] intMatrix) {
        int rows = intMatrix.length;
        int columns = intMatrix[0].length;

        double[][] doubleMatrix = new double[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                doubleMatrix[i][j] = (double) intMatrix[i][j];

            }
        }

        return doubleMatrix;
    }
    public  int[][] convertDoubleToInt(double[][] doubleMatrix) {
        int rows = doubleMatrix.length;
        int columns = doubleMatrix[0].length;

        int[][] intMatrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                intMatrix[i][j] = (int) Math.round(doubleMatrix[i][j]);
                //System.out.println(doubleMatrix[i][j]);
            }
        }

        return intMatrix;
    }
    public ImmutableMatrix transpose() {
        int rows = getRows();
        int columns = getColumns();

        ImmutableMatrix transposedMatrix = new ImmutableMatrix(columns, rows);
        int[][] transposed = transposedMatrix.getMatrix();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }

        return transposedMatrix;
    }
    public void GetColumnsAndRows(){
        System.out.println("Rows: "+this.getRows()+"; Columns: "+this.getColumns());
    }


    public static Matrix createDiagonalMatrix(int[] diagonalValues) {
        int size = diagonalValues.length;
        Matrix diagonalMatrix = new Matrix(size, size);
        int[][] matrixData = diagonalMatrix.getMatrix();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    matrixData[i][j] = diagonalValues[i];
                } else {
                    matrixData[i][j] = 0;
                }
            }
        }
        return diagonalMatrix;
    }

    public static Matrix createIdentityMatrix(int size) {
        Matrix identityMatrix = new Matrix(size, size);
        int[][] matrixData = identityMatrix.getMatrix();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    matrixData[i][j] = 1;
                } else {
                    matrixData[i][j] = 0;
                }
            }
        }
        return identityMatrix;
    }

    public static Matrix createRandomRowMatrix(int length, int minRandomValue, int maxRandomValue) {
        if (length <= 0) {
            throw new IllegalArgumentException("Довжина матриці-строки повинна бути більшою за 0");
        }

        Matrix randomRowMatrix = new Matrix(1, length);
        int[][] matrixData = randomRowMatrix.getMatrix();
        Random random = new Random();

        for (int j = 0; j < length; j++) {
            int randomValue = random.nextInt(maxRandomValue - minRandomValue + 1) + minRandomValue;
            matrixData[0][j] = randomValue;
        }

        return randomRowMatrix;
    }

    public static Matrix createRandomColumnMatrix(int length, int minRandomValue, int maxRandomValue) {
        if (length <= 0) {
            throw new IllegalArgumentException("Довжина матриці-стовпчика повинна бути більшою за 0");
        }

        Matrix randomColumnMatrix = new Matrix(length, 1);
        int[][] matrixData = randomColumnMatrix.getMatrix();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int randomValue = random.nextInt(maxRandomValue - minRandomValue + 1) + minRandomValue;
            matrixData[i][0] = randomValue;
        }

        return randomColumnMatrix;
    }
    public void printMatrix() {
        int rows = getRows();
        int columns = getColumns();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.printf("%5d", matrix[i][j]);
            }
            System.out.println();
        }
    }


}



