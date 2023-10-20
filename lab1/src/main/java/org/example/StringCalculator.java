package org.example;

public class StringCalculator {
    int add(String numbers) {
        if(numbers==""){
            return 0;
        }
        int result = 0;
        String prev="";
        String number = "";
        String delimeter = "";
         numbers=numbers.replace("\\n",",");
        for (int i = 0; i < numbers.length(); i++) {
            char charDigit = numbers.charAt(i);

            if (!Character.isDigit(charDigit)) {
                System.out.print(delimeter);
                if (prev.equals(",")) {

                    return 0;
                }
                if (charDigit == ',') {
                    result += Integer.parseInt(number.trim());
                    prev = ",";
                    number = "";
                    continue;
                }
            }
            number += charDigit;
            prev=number;
        }
        result += Integer.parseInt(number.trim());
        return result;
    }
}
