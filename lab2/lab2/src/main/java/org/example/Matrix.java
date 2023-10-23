package org.example;

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
}
