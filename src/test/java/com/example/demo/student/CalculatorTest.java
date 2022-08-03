package com.example.demo.student;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Calculator testing:

class CalculatorTest {

    @Test
    void twoPlusTwoIsFour(){
        Calculator calculator = new Calculator();
        assertEquals(4, calculator.add(2,2));
    }

    @Test
    void threePlusSevenIsTen(){
        Calculator calculator = new Calculator();
        assertEquals(10, calculator.add(3,7));

    }

}