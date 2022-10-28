package org.example;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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



}
