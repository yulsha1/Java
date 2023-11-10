package org.example;

import java.awt.desktop.SystemEventListener;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(2, 2);
        matrix.fillRandomMatrix(1, 10);
        matrix.printMatrix();
        System.out.println();
      /*  ImmutableMatrix immutableMatrix = new ImmutableMatrix(5, 5);
        immutableMatrix.fillRandomMatrix(1, 3);
        immutableMatrix.printMatrix();
        //  System.out.println(matrix.hashCode());
        // System.out.println(immutableMatrix.hashCode());
        System.out.println(matrix.equals(immutableMatrix));
        Matrix matrix1=immutableMatrix.multiply(-2);
        matrix1.printMatrix();
        Matrix matrix2=matrix.multiply(-2);
        System.out.println();
        matrix2.printMatrix();
        System.out.println();
        Matrix matrix3=matrix.multiply(immutableMatrix);
        matrix3.printMatrix();
        System.out.println();
        ImmutableMatrix matrix4=new ImmutableMatrix(matrix3) ;
        matrix4.printMatrix();
        System.out.println();*/
        Matrix reverseMatrix=matrix.transpose();
        reverseMatrix.printMatrix();
        System.out.println();
        Matrix matrix5= matrix.inverse();
        matrix5.printMatrix();


    }
}
