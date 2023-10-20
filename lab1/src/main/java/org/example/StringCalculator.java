package org.example;

public class StringCalculator {
    int add (String numbers){
        int result=0;
        for(int i=0;i<numbers.length();i++){
            char charDigit = numbers.charAt(i);
            if(charDigit==',')continue;
            int digit = Character.getNumericValue(charDigit);
            result += digit;
        }
        return result;
    }
}
