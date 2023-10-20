package org.example;

public class StringCalculator {
    int add (String numbers){
        int result=0;
        String number="";
        for(int i=0;i<numbers.length();i++){
            char charDigit = numbers.charAt(i);

            if(charDigit==','){
                result+=Integer.parseInt(number);
                number="";
                continue;
            }
            number+=charDigit;
        }
        result+=Integer.parseInt(number);
        return result;
    }
}
