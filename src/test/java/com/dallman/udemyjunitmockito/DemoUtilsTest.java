package com.dallman.udemyjunitmockito;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DemoUtilsTest {

    @Test
    void testEqualsAndNotEquals() {
        // Step 1: Create an instance of the class we want to test
        DemoUtils demoUtils = new DemoUtils();

        int expected = 6;
        int unexpected = 7;

        // Step 2: Call the method we want to test
        int result = demoUtils.addTwoNumbers(3,3);

        // Call our test method within the assertion itself
        assertEquals(expected, demoUtils.addTwoNumbers(3,3), "3 + 3 must be 6");

        // Step 3: Assert the value and verify the result - Without calling test method within the assertion
        assertEquals(expected, result, "3+3 must be 6");
        assertNotEquals(unexpected, result, "3+3 must not be be 6");

    }

    @Test
    void testNullAndNotNull() {
        DemoUtils demoUtils = new DemoUtils();
        String expected = null;
        String notNull = "This is NotNull";

        assertNull(demoUtils.checkNull(expected), "Object should be null");
        assertNotNull(demoUtils.checkNull(notNull), "Object should NOT be null");
    }
}
