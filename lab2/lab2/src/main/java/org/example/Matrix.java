package org.example;
import java.util.Scanner;
public class Matrix {
    private int[][] matrix;
    public Matrix(){
        matrix=new int[0][0];
    }
    public Matrix(int rows, int columns) {
        matrix = new int[rows][columns];
    }
    public Matrix(Matrix matrixToCopy){
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
        Scanner scanner=new Scanner(System.in);
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
            throw new IllegalArgumentException("Invalid column index.");
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
}
