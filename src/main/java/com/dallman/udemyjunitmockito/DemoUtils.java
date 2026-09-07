package com.dallman.udemyjunitmockito;

public class DemoUtils {

    public static void main(String[] args) {

    }

    public int addTwoNumbers(int a, int b) {
        return a + b;
    }

    public Object checkNull(Object object) {
        if (object != null) {
            return object;
        }
        return null;
    }
}
