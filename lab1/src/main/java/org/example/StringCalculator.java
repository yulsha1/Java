package org.example;
import java.util.List;
import java.util.ArrayList;

public class StringCalculator {
    int add(String numbers) {
        if (numbers == "") {
            return 0;
        }
        int result = 0;
        String prev = "";
        String number = "";
        String minusNumbers = "";
        List<String> delimeters = new ArrayList<String>();
        if (numbers.startsWith("//")) {
            numbers = numbers.substring(2);
            if(numbers.startsWith("[]")){
                numbers = numbers.substring(4);
                String delimeter="";
                String buffer="";
                for(int i=0;i<numbers.length();i++) {
                    char charDigit = numbers.charAt(i);
                    if (Character.isDigit(charDigit) || charDigit == '-') {
                        continue;
                    }
                    if (delimeter.equals("")) {
                        delimeter = "" + charDigit;
                        break;
                    }
                }
                numbers=numbers.replaceAll("\\*+", ",");

            }else{
            char delimeter = numbers.charAt(0);
            numbers = numbers.substring(1);
            numbers = numbers.replace(delimeter, ',');}
        }
        numbers = numbers.trim();
        numbers = numbers.replace("\\n", ",");
        if (numbers.startsWith(",")) {
            numbers = numbers.substring(1);
        }
        System.out.println(numbers);
        for (int i = 0; i < numbers.length(); i++) {
            char charDigit = numbers.charAt(i);

            if (!Character.isDigit(charDigit) && charDigit != '-') {
                System.out.println(number);
                if (prev.equals(",")) {
                    System.out.println("Invalid data");
                    return 0;
                }
                if (charDigit == ',') {
                    int convertNumber = Integer.parseInt(number.trim());
                    if (convertNumber > 1000) {
                        prev = "" + convertNumber;
                        number = "";
                        continue;
                    }
                    if (convertNumber < 0) {
                        minusNumbers += convertNumber + ",";
                        prev = "" + convertNumber;
                        number = "";
                        continue;
                    }
                    result += convertNumber;
                    prev = ",";
                    number = "";
                    continue;
                }
            }
            number += charDigit;
            prev = number;
        }
        int convertNumber = Integer.parseInt(number.trim());
        if (convertNumber < 0) {
            minusNumbers += convertNumber + ",";

        } else if (convertNumber > 1000) {

        } else {
            result += convertNumber;
        }
        if (minusNumbers != "") {
            System.out.println("List of minus numbers :" + minusNumbers);
        }
        return result;
    }
}
