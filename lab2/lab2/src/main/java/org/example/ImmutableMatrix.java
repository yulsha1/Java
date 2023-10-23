package org.example;
public final class ImmutableMatrix {
    private final int[][] matrix;

    public ImmutableMatrix(Matrix matrix) {
        if (matrix != null) {
            int rowCount = matrix.getRows();
            int columnCount = matrix.getColumns();
            this.matrix = new int[rowCount][columnCount];
            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < columnCount; j++) {
                    this.matrix[i][j] = matrix.getElement(i, j);
                }
            }
        } else {
            this.matrix = null;
        }
    }

    public int getElement(int row, int column) {
        if (matrix == null || row < 0 || row >= matrix.length || column < 0 || column >= matrix[0].length) {
            throw new IllegalArgumentException("Invalid matrix dimensions or indices");
        }
        return matrix[row][column];
    }

    public int getRowCount() {
        if (matrix == null) {
            return 0;
        }
        return matrix.length;
    }

    public int getColumnCount() {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        return matrix[0].length;
    }
}
