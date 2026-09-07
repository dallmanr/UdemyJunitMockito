package com.dallman.udemyjunitmockito;

public class DemoUtils {
    private String academy ="Academy";
    private String academyDuplicate = academy;

    public static void main(String[] args) {

    }

    public int addTwoNumbers(int a, int b) {
        return a + b;
    }

    public int multiplyTwoNumbers(int a, int b) {
        return a * b;
    }

    public boolean isGreater(int a, int b) {
        return a > b;
    }

    public Object checkNull(Object object) {
        if (object != null) {
            return object;
        }
        return null;
    }

    public Object isSame(Object object1, Object object2) {
        if (object1 == object2) {
            return true;
        } else {
            return false;
        }
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getAcademyDuplicate() {
        return academyDuplicate;
    }

    public void setAcademyDuplicate(String academyDuplicate) {
        this.academyDuplicate = academyDuplicate;
    }
}
