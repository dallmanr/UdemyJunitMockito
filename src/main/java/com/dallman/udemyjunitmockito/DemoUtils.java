package com.dallman.udemyjunitmockito;

public class DemoUtils {

    public static void main(String[] args) {

    }

    public int addTwoNumbers(int a, int b) {
        return a + b;
    }

    public int multiplyTwoNumbers(int a, int b) {
        return a * b;
    }

    public boolean isGreater(int a, int b) {
        if (a > b) {
            return true;
        } else {
            return false;
        }
    }

    public Object checkNull(Object object) {
        if (object != null) {
            return object;
        }
        return null;
    }
}
