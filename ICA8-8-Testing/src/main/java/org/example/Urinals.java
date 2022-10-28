package org.example;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Urinals {

    public static void main(String[] args) {
        System.out.println("Please select the type of input");
        System.out.println("Enter 0 as input for file input");
        System.out.println("Enter 1 as input for keyboard input");
        Scanner myObj = new Scanner(System.in);
        String input = myObj.nextLine();
        if(input.equals("1")){
            System.out.println("Please enter the string for urinals");
            String s = myObj.nextLine();
            int invalid = stringcheck(s);
            if(invalid == -1){
                System.out.println(" -1  Invalid String Input");
            }
            else {
                int ans = UrinalCount(s);
                System.out.println(ans);
            }
        }
        else if(input.equals("0")){

        }
        else{
            System.out.println("invalid input choice please run the program again and select from 0 and 1 only ");
        }
    }

    public static int stringcheck(String s){
        char[] temp = s.toCharArray();
        int counter = 0;
        for(int i = 0; i < temp.length-1; i++){

            if(temp[i] == '1' && temp[i+1] == '1'){
                counter++;
            }
            if(temp[i] != '0' && temp[i]!= '1'){
                return -1;
            }
        }
        if(counter == temp.length-1){
            return -1;
        }
        else
        return 0;
    }
    public static int UrinalCount(String s){
        char[] temp = s.toCharArray();
        int count = 0;
        if(temp.length == 1){
            if(temp[0] == '0'){
                return 1;
            }
            else
                return 0;
        }

        if(temp[0] == '0' && temp[1] == '0'){
            count++;
            temp[0] = '1';
        }
        if(temp.length == 2){
            return count;
        }

        if(temp[temp.length-2] == '0' && temp[temp.length-1] == '0'){
            count++;
            temp[temp.length-1] = '1';
        }

        for(int i = 1 ; i<temp.length-1; i++){
            if(temp[i-1] == '0' && temp[i]== '0' && temp[i+1] == '0'){
                count++;
                temp[i] = '1';
            }
        }
        return count;
    }
}