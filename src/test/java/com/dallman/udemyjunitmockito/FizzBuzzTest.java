package com.dallman.udemyjunitmockito;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

//Test driven development example
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FizzBuzzTest {

    // n % 3 == "Fizz", n % 5 == "Buzz", n % 15 == "FizzBuzz", else "n"

    @Test
    @DisplayName("Testing n / 3")
    @Order(1)
    void testForDivisibleByThree() {
        String expected = "Fizz";
        assertEquals(expected, FizzBuzz.compute(3), "Should return Fizz");
    }

    @Order(2)
    @Test
    @DisplayName("Testing n / 5")
    void testForDivisibleByFive() {
        String expected = "Buzz";
        assertEquals(expected, FizzBuzz.compute(5), "Should return Buzz");
    }

    @Test
    @DisplayName("Testing n / 15")
    @Order(3)
    void testDivisibleByFifteen() {
        String expected = "FizzBuzz";
        assertEquals(expected, FizzBuzz.compute(15), "Should return FizzBuzz");
    }

    @Test
    @DisplayName("Testing n !/ 3 or 5")
    @Order(3)
    void testNotDivisibleByFifteen() {
        String expected = "16";
        assertEquals(expected, FizzBuzz.compute(16), "Should return n");
    }

}
