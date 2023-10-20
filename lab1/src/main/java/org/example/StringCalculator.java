package org.example;

public class StringCalculator {
    int add(String numbers) {
        if(numbers==""){
            return 0;
        }
        int result = 0;
        String prev="";
        String number = "";

        if(numbers.startsWith("//")){
            numbers=numbers.substring(2);
            char delimeter=numbers.charAt(0);
            numbers=numbers.substring(1);
            numbers=numbers.replace(delimeter,',');
        }
       numbers= numbers.trim();
        numbers=numbers.replace("\\n",",");
        if(numbers.startsWith(",")) {
            numbers = numbers.substring(1);
        }

        for (int i = 0; i < numbers.length(); i++) {
            char charDigit = numbers.charAt(i);

            if (!Character.isDigit(charDigit)) {

                if (prev.equals(",")) {
                    System.out.println("Invalid data");
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
