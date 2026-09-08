package com.dallman.udemyjunitmockito;

import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DemoUtils {
    private String academy ="Academy";
    private String academyDuplicate = academy;
    private String[] firstThreeLettersOfAlphabet = {"A", "B", "C"};
    private List<String> academyInList = List.of("JUnit", "Mockito", "MockMvc");

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

    public String[] getFirstThreeLettersOfAlphabet() {
        return firstThreeLettersOfAlphabet;
    }

    public void setFirstThreeLettersOfAlphabet(String[] firstThreeLettersOfAlphabet) {
        this.firstThreeLettersOfAlphabet = firstThreeLettersOfAlphabet;
    }

    public List<String> getAcademyInList() {
        return academyInList;
    }

    public void setAcademyInList(List<String> academyInList) {
        this.academyInList = academyInList;
    }

    public String throwException(int a) throws Exception {
        if (a<0) {
            throw new Exception("Value should be > 0");
        }
        return "Value is >= 0";
    }

    public void timeout(int waitTime) throws InterruptedException {
        System.out.println("Sleeping for + " + waitTime + " seconds");
        Thread.sleep(waitTime * 1000);
        System.out.println("Waking");
    }
}
