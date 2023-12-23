package org.example;

public interface IMatrix {

    int getRows();

    int getColumns();

    int[][] getMatrix();

    void fillFullMatrix();

    int getElement(int row, int column);

    int[] getRow(int row);

    int[] getColumn(int column);

    boolean equals(Object o);

    int hashCode();

    void fillRandomMatrix(int minRandomValue, int maxRandomValue);

    ImmutableMatrix add(IMatrix otherMatrix);

    ImmutableMatrix  multiply(int scalar);

    ImmutableMatrix multiply(IMatrix otherMatrix);

    ImmutableMatrix inverse();

    double[][] convertToIntToDouble(int[][] intMatrix);

    int[][] convertDoubleToInt(double[][] doubleMatrix);

    ImmutableMatrix transpose();

    void printMatrix();
}

