package org.example;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.SingularMatrixException;
import java.util.Arrays;

public final class ImmutableMatrix extends Matrix {

    public ImmutableMatrix() {
        super();
    }

    public ImmutableMatrix(int rows, int columns) {
        super(rows, columns);
    }

    public ImmutableMatrix(Matrix matrixToCopy) {
        super(matrixToCopy);
    }
}
