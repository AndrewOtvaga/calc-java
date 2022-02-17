package com.company;
import java.util.Scanner;
public class calculatorWithrRomanNumberNew {

    public static void main(String[] args) {
        var scaner = new Scanner(System.in);

        while(true){

            var line = scaner.nextLine();
            line = line.replace(" " , "");
            var includeRoman = line.matches(".*([IVXLCDM]).*");
            var includeIndian = line.matches(".*([0-9]).*");
            if (includeRoman && includeIndian){
                System.out.println("Error input");
            }
            else {
                int i = signs(line);

                var leftside = line.substring(0, i);
                var rightside = line.substring(i + 1);
                var leftnumber = parsNumbers(leftside);
                var rightnumber = parsNumbers(rightside);
                char sign = line.charAt(i);
                int result = mathematicOperand(leftnumber, rightnumber, sign);
                if (includeIndian) {
                    System.out.println(result);
                }
                else {
                    System.out.println(toString(result));
                }
            }
        }
    }
    public static int mathematicOperand (int leftNumber, int rightNuber, char sign){
        switch (sign){
            case'+':return leftNumber + rightNuber;
            case'-':return leftNumber - rightNuber;
            case'*':return leftNumber * rightNuber;
            case'/':return leftNumber / rightNuber;
            default: return 0;
        }
    }
    public static int signs (String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/')
                return i;
        }
        return 0;
    }
    public static int parsNumbers (String str){
        if(!str.matches(".*([IVXLCDM])")){
            return Integer.parseInt(str);
        }
        char[]massiveRomanNumbers = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[]massiveIndianNumbers = {1, 5, 10, 50, 100, 500, 1000};
        int result = 0;
        int i=0;
        while(i<str.length()) {
            char RomanNumber = str.charAt(i);
            int j = 0;
            for (; j < massiveRomanNumbers.length - 1; j++)
                if (massiveRomanNumbers[j] == RomanNumber)
                    break;
            i++;
            if (i == str.length()) {
                result += massiveIndianNumbers[j];
            }
            else
            {
                char nextRomanNumber = str.charAt(i);
                int nextCharPosition = 0;
                for (; nextCharPosition < massiveRomanNumbers.length - 1; nextCharPosition++)
                    if (massiveRomanNumbers[nextCharPosition] == nextRomanNumber)
                        break;
                if (massiveIndianNumbers[j] < massiveIndianNumbers[nextCharPosition]) {
                    result += massiveIndianNumbers[nextCharPosition] - massiveIndianNumbers[j];
                    i++;
                }
                else
                {
                    result += massiveIndianNumbers[j];
                }
            }
        }
        return  result;
    }

    public static String toString(int num) {
        String[]massiveRomanNumbers = { "M",  "CM",  "D",  "CD", "C",  "XC",
                "L",  "XL",  "X",  "IX", "V",  "IV", "I" };
        int[]massiveIndianNumbers = { 1000,  900,  500,  400,  100,   90,
                50,   40,   10,    9,    5,    4,    1 };
        String roman = "";
        int N = num;
        for (int i = 0; i < massiveIndianNumbers.length; i++) {
            while (N >= massiveIndianNumbers[i]) {
                roman += massiveRomanNumbers[i];
                N -= massiveIndianNumbers[i];
            }
        }
        return roman;
    }
}
