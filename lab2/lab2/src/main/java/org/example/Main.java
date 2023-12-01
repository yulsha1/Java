package org.example;

import java.awt.desktop.SystemEventListener;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

//        int[][] myArray = {
//                {1, 6, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };
//
//        Matrix myMatrix = new Matrix(myArray);
//        myMatrix.printMatrix();
//        System.out.println();


        Matrix matrix = new Matrix(2,2);
        matrix.fillRandomMatrix(0, 10);
        matrix.printMatrix();
        System.out.println();


//        ImmutableMatrix matrix1 = new ImmutableMatrix(matrix);
//        matrix1.printMatrix();
//        System.out.println();
//
//        ImmutableMatrix matrix2 = matrix1.add(matrix);
//        matrix2.printMatrix();
//        System.out.println();
//
//        matrix2.fillRandomMatrix(1, 10);
//        matrix2.printMatrix();
//
//        System.out.println(matrix.equals(matrix1));

        ImmutableMatrix matrix5  = matrix.inverse();
        matrix5.printMatrix();


//        ImmutableMatrix immutableMatrix = new ImmutableMatrix(3, 4);
//        immutableMatrix.fillRandomMatrix(1, 10);
//        immutableMatrix.printMatrix();
//        System.out.println();




//        Копія мaтриці
//        Matrix matrix = new Matrix(3,3);
//        matrix.fillRandomMatrix(1, 10);
//        Matrix matrix2 = new Matrix(matrix);
//        matrix.printMatrix();
//        System.out.println();
//        matrix2.printMatrix();


//        Матриця заданого розміру
//        ImmutableMatrix immutableMatrix = new ImmutableMatrix(4, 4);
//        immutableMatrix.fillRandomMatrix(1, 10);
//        immutableMatrix.printMatrix();


//        отримати заданий елемент
//        ImmutableMatrix immutableMatrix = new ImmutableMatrix(4, 4);
//        immutableMatrix.fillRandomMatrix(1, 10);
//        immutableMatrix.printMatrix();
//        System.out.println(immutableMatrix.getElement(0,0));


//        отримати заданий рядок
//        Matrix matrix = new Matrix(4, 4);
//        matrix.fillRandomMatrix(1, 10);
//        matrix.printMatrix();
//        System.out.println(matrix.getRows());


//        отримати заданий стовпчик
//        Matrix matrix = new Matrix(4, 4);
//        matrix.fillRandomMatrix(1, 10);
//        matrix.printMatrix();
//        System.out.println(matrix.getColumns());


//        Метод equals
//        Matrix matrix = new Matrix(4, 4);
//        matrix.fillRandomMatrix(1, 10);
//        matrix.printMatrix();
//        System.out.println();
//
//        ImmutableMatrix immutableMatrix = new ImmutableMatrix(4, 4);
//        immutableMatrix.fillRandomMatrix(1, 10);
//        immutableMatrix.printMatrix();
//
//        System.out.println(matrix.equals(immutableMatrix));


//         Метод hashcode
//         Matrix matrix = new Matrix(4, 4);
//         matrix.fillRandomMatrix(1, 10);
//         matrix.printMatrix();
//
//         System.out.println(matrix.hashCode());


//        Додавання матриць
//        ImmutableMatrix immutableMatrix = new ImmutableMatrix(3, 3);
//        immutableMatrix.fillRandomMatrix(1, 10);
//        immutableMatrix.printMatrix();
//        System.out.println();
//
//        Matrix matrix = new Matrix(3, 3);
//        matrix.fillRandomMatrix(1, 10);
//        Matrix matrix1 = immutableMatrix.add(matrix);
//        matrix.printMatrix();
//        System.out.println();
//
//        matrix1.printMatrix();


//        Множення на скаляр
//        ImmutableMatrix immutableMatrix = new ImmutableMatrix(3, 3);
//        immutableMatrix.fillRandomMatrix(1, 10);
//        immutableMatrix.printMatrix();
//        System.out.println();
//
//        Matrix matrix1=immutableMatrix.multiply(-2);
//        matrix1.printMatrix();


//        Множення матриць
//        ImmutableMatrix immutableMatrix = new ImmutableMatrix(4, 3);
//        immutableMatrix.fillRandomMatrix(1, 10);
//        immutableMatrix.printMatrix();
//        System.out.println();
//
//        Matrix matrix = new Matrix(3, 3);
//        matrix.fillRandomMatrix(1, 10);
//        Matrix matrix1 =immutableMatrix.multiply(matrix);
//        matrix.printMatrix();
//        System.out.println();
//
//        matrix1.printMatrix();


//        Транспонована матриця
//        Matrix matrix = new Matrix(4, 4);
//        matrix.fillRandomMatrix(1, 10);
//        Matrix matrix1 = matrix.transpose();
//        matrix.printMatrix();
//        System.out.println();
//        matrix1.printMatrix();


//        Діагональна матриця
//        int[] diagonalValues = {3, 2, 8, 4};
//        Matrix diagonalMatrix = Matrix.createDiagonalMatrix(diagonalValues);
//        diagonalMatrix.printMatrix();


//        Одиничнa матриця
//        Matrix identityMatrix = Matrix.createIdentityMatrix(3);
//        identityMatrix.printMatrix();


//        Матриця-строка
//        Matrix matrix = Matrix.createRandomRowMatrix(5, 1, 10);
//        matrix.printMatrix();


//        Матриця-стовпчик
//        Matrix matrix = Matrix.createRandomColumnMatrix(5, 1, 10);
//        matrix.printMatrix();


//        Оберенена матриця
//        ImmutableMatrix immutableMatrix = new ImmutableMatrix(3, 3);
//        immutableMatrix.fillRandomMatrix(1, 10);
//        Matrix matrix5 = immutableMatrix.inverse();
//        immutableMatrix.printMatrix();
//        System.out.println();
//        matrix5.printMatrix();


    }
}

