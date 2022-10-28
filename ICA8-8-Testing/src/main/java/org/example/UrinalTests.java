package org.example;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UrinalTests {
    @Test
    public void test1(){
        assertEquals( 0, new Urinals().UrinalCount("10101") );
        System.out.println("====== Karan Sorot == TEST TWO EXECUTED =======");
    }
}
