package com.company;
import java.util.Scanner;
public class calculatorWithautRomanNumber {

    public static void main(String[] args) {
    var scaner = new Scanner(System.in);

    while(true){

    var line = scaner.nextLine();
    line = line.replace(" " , "");
    int i = 0;
    for (;i<line.length();i++) {
        if(line.charAt(i) == '+' || line.charAt(i) == '-' || line.charAt(i) == '*' || line.charAt(i) == '/')
            break;}
    var leftside = line.substring(0,i);
    var rightside = line.substring(i+1);
    var leftnumber = Integer.parseInt(leftside);
    var rightnumber = Integer.parseInt(rightside);
    char sign = line.charAt(i);
    if(sign == '+') {
        System.out.println(leftnumber + rightnumber);
    }else
    if(sign == '-') {
        System.out.println(leftnumber - rightnumber);
    }else
    if(sign == '*') {
        System.out.println(leftnumber * rightnumber);
    }else
    if(sign == '/') {
        System.out.println(leftnumber / rightnumber);
    }else
        {System.out.println("ERROR");}
    }


}
}