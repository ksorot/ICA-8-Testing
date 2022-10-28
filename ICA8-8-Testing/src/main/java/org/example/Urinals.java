package org.example;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
            Urinals.inputkeyboard();
        }
        else{
            List<String> fileurinals = Urinals.fileread();
            List<Integer> temp = new ArrayList<>();
            temp = Urinals.fileUrinalcount(fileurinals);
            Urinals.fileoutput(temp);

        }
    }

    public static int inputkeyboard(){
            while(true) {
                System.out.println("Please enter the string for urinals ( Enter -1 to exit)");
                Scanner myObj = new Scanner(System.in);
                String s = myObj.nextLine();
                int invalid = stringcheck(s);
                if (invalid == -2) {
                    break;
                }
                    else if (invalid == -1) {
                        System.out.println("-1");
                    }
                    else {
                        int ans = UrinalCount(s);
                        System.out.println(ans);
                }
            }
            return 0;
    }

    public static List<String> fileread(){
        List<String> temp = new ArrayList<>();
        try {
            FileReader Reader = new FileReader("urinal.dat");
            Scanner readerin = new Scanner (Reader);
            while(readerin.hasNextLine()){
                temp.add(readerin.nextLine());
            }
            return temp;
        }catch(Exception e){
            System.out.println(e);
        }
        return temp;
    }

    public static List<Integer> fileUrinalcount(List<String> fileurinals){
        int n = fileurinals.size();
        List<Integer> answer = new ArrayList<>();
        for(int i =0 ; i<n ; i++){
            int val = Urinals.stringcheck(fileurinals.get(i));
            if(val == -2){
                break;
            }
            else if (val == -1){
                answer.add(-1);
            }
            else{
                int ans = UrinalCount(fileurinals.get(i));
                answer.add(ans);
            }
        }
        return answer;
    }

    public static void  fileoutput(List<Integer> ans){
        int a =0;
        try {
            FileReader Reader = new FileReader("check.txt");
            Scanner readerin = new Scanner (Reader);
            a = readerin.nextInt();
            }
            catch(Exception e){
            System.out.println(e);
        }

        try{

            FileWriter buildfile = new FileWriter("rule" + a + ".txt");
         for(int i = 0; i < ans.size(); i++){
             buildfile.write(String.valueOf(ans.get(i)) + "\n");
         }
         buildfile.close();
        }catch(IOException e){
            System.out.println(e);
        }
        try{
            FileWriter buildfile = new FileWriter("check.txt");
                buildfile.write(String.valueOf(++a));
            buildfile.close();
        }catch(IOException e){
            System.out.println(e);
        }

    }

    public static int stringcheck(String s){
        if(s.equals("-1")) {
            return -2;
        }
        char[] temp = s.toCharArray();
        int counter = 0;
        for(int i = 0; i < temp.length-1; i++) {

            if (temp[i] == '1' && temp[i + 1] == '1') {
                counter++;
            }
            if(temp[i] != '1' && temp[i]!='0'){
                return -1;
            }
        }
        for(int i = 0; i < temp.length; i++) {
            if(temp[i] != '1' && temp[i]!='0'){
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