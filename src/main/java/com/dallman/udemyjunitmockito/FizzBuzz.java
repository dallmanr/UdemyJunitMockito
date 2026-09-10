package com.dallman.udemyjunitmockito;

public class FizzBuzz {

    void fizzBuzz(int range) {

        for (int i = 1; i <= range; i++) {
            System.out.println(compute(i));
        }
    }

    public String compute(int number) {
        if (number % 15 == 0) {
            return ("FizzBuzz");
        } else if (number % 3 == 0) {
            return ("Fizz");
        } else if (number % 5 == 0) {
            return ("Buzz");
        } else {
            return number + "";
        }
    }
}
