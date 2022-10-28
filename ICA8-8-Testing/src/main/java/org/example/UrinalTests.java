package org.example;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.deepEquals;
import static org.junit.jupiter.api.Assertions.*;

public class UrinalTests {

    // urinal logic check
    @Test
    public void test1() {
        assertEquals(0, new Urinals().UrinalCount("10101"));
        System.out.println("====== Karan Sorot == TEST ONE EXECUTED =======");
    }

    // invalid input on the basis of Urinal rules
    @Test
    public void test2() {
        assertEquals(-1, new Urinals().stringcheck("11111"));
        System.out.println("====== Karan Sorot == TEST TWO EXECUTED =======");
    }

    // invalid input on the basis of any other character other than 0 and 1 like string
    @Test
    public void test3() {
        assertEquals(-1, new Urinals().stringcheck("abcd"));
        System.out.println("====== Karan Sorot == TEST THREE EXECUTED =======");
    }


    // correct format of input string
    @Test
    public void test4() {
        assertEquals(0, new Urinals().stringcheck("101"));
        System.out.println("====== Karan Sorot == TEST FOUR EXECUTED =======");
    }


    // file read valid input
    @Test
    public void test5() {
        List<String> arr = new ArrayList<>();
        arr.add("10001");
        arr.add("10000");
        assertEquals( 1, new Urinals().fileUrinalcount(arr).get(0));
        System.out.println("====== Karan Sorot == TEST FIVE EXECUTED =======");
    }

    //file read valid input
    @Test
    public void test6() {
        List<String> arr = new ArrayList<>();
        arr.add("10001");
        arr.add("10000");
        assertEquals( 2, new Urinals().fileUrinalcount(arr).get(1));
        System.out.println("====== Karan Sorot == TEST SIX EXECUTED =======");
    }

    // file exists or not
    @Test
    public void test7(){
        File f = new File("urinal.dat");
        assertEquals(true, f.exists());
        System.out.println("====== Karan Sorot == TEST SEVEN EXECUTED =======");
    }


    // If file is empty
    @Test
    public void test8(){
        try {
            BufferedReader read = new BufferedReader(new FileReader("urinal.dat"));
            assertNotNull(read.readLine());
        } catch (Exception error){
            System.out.println(error);
        }
        System.out.println("====== Karan Sorot == TEST EIGHT EXECUTED =======");
    }

    //Bad File name
    @Test
    public void test9(){
        File f = new File("rulesabc.txt");
        assertEquals(false, f.exists());
        System.out.println("====== Karan Sorot == TEST NINE EXECUTED =======");
    }


}
