package org.example;

import java.awt.desktop.SystemEventListener;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Comparator;
import java.util.Collections;
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
            if (numbers.startsWith("[]")) {
                numbers = numbers.substring(4);
                String delimeter = "";

                for (int i = 0; i < numbers.length(); i++) {
                    char charDigit = numbers.charAt(i);
                    if (Character.isDigit(charDigit) || charDigit == '-') {
                        continue;
                    }
                    if (delimeter.equals("")) {
                        delimeter = "" + charDigit;
                        break;
                    }
                }
                numbers = numbers.replaceAll("\\*+", ",");

            } else if (numbers.startsWith("[")) {
                Pattern pattern = Pattern.compile("\\[(.*?)\\]");
                Matcher matcher = pattern.matcher(numbers);
                while (matcher.find()) {
                    String value = matcher.group(1);
                    delimeters.add(value);
                }

                Comparator<String> lengthComparator = new Comparator<String>() {
                    @Override
                    public int compare(String s1, String s2) {
                        return Integer.compare(s1.length(), s2.length());
                    }
                };


                Collections.sort(delimeters, lengthComparator);
                Collections.reverse(delimeters);

                for(int i=0;i<delimeters.size();i++){
                    numbers=numbers.replace("["+delimeters.get(i)+"]","");
                }
                for(int i=0;i<delimeters.size();i++){
                    numbers=numbers.replace(delimeters.get(i),",");

                }


            } else {
                char delimeter = numbers.charAt(0);
                numbers = numbers.substring(1);
                numbers = numbers.replace(delimeter, ',');
            }

        }
        numbers = numbers.trim();
        numbers = numbers.replace("\\n", ",");
        if (numbers.startsWith(",")) {
            numbers = numbers.substring(1);
        }

        if(numbers.endsWith(",")){
            System.out.println("Invalid data");
            return 0;
        }
        for (int i = 0; i < numbers.length(); i++) {
            char charDigit = numbers.charAt(i);

            if (!Character.isDigit(charDigit) && charDigit != '-') {

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
