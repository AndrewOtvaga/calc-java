package com.company;
import java.util.Scanner;
public class calculatorWithrRomanNumberNew {

    public static void main(String[] args) {
        var scaner = new Scanner(System.in);

        while(true){

            var line = scaner.nextLine();
            line = line.replace(" " , "");
            int i = signs(line);

            var leftside = line.substring(0,i);
            var rightside = line.substring(i+1);
            var leftnumber = parsNumbers(leftside);
            var rightnumber = parsNumbers(rightside);
            char sign = line.charAt(i);
            System.out.println(mathematicOperand(leftnumber, rightnumber, sign ));
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
        if(!str.matches(".*([IVXLMDC])")){
            return Integer.parseInt(str);
        }
        char[]massiveRomanNumbers = {'I', 'V', 'X', 'L', 'M', 'D', 'C'};
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

            } else {
                char nextRomanNumber = str.charAt(i);
                int nextCharPosition = 0;
                for (; nextCharPosition < massiveRomanNumbers.length - 1; nextCharPosition++)
                    if (massiveRomanNumbers[nextCharPosition] == nextRomanNumber)
                        break;
                if (massiveIndianNumbers[j] < massiveIndianNumbers[nextCharPosition]) {
                    result += massiveIndianNumbers[nextCharPosition] - massiveIndianNumbers[j];
                    i++;
                } else {
                    result += massiveIndianNumbers[j];
                }
            }
        }
        return  result;
    }
}
