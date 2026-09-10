package com.dallman.udemyjunitmockito;

public class FizzBuzz {

    public void fizzBuzz(int range) {

        for (int i = 1; i <= range; i++) {
            if (i % 15 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

    public static String compute(int number) {
        if (number % 15 == 0) {
            return ("FizzBuzz");
        } else if (number % 3 == 0) {
            return ("Fizz");
        } else if (number % 5 == 0) {
            return ("Buzz");
        } else {
            return null;
        }
    }
}
