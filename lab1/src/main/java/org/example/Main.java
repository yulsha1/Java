package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numbers;
        while (true) {
            System.out.print("Enter numbers: ");
            numbers = scanner.nextLine();
            if (numbers.equals("ex")) return;
            int result = new StringCalculator().add(numbers);
            System.out.println("Result: " + result);

        }
    }
}
