package org.example;

import java.util.Scanner;

public class Urinals {

    public static void main() {
        System.out.println("Please select the type of input");
        System.out.println("Enter 0 as input for file input");
        System.out.println("Enter 1 as input for keyboard input");
        Scanner myObj = new Scanner(System.in);
        String input = myObj.nextLine();
        Urinals urinals = new Urinals();
        int ans = urinals.UrinalCount(input);
    }
    public int UrinalCount(String n){
        return 2;
    }
}