package com.dallman.udemyjunitmockito;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;


@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
public class DemoUtilsTest {

    DemoUtils demoUtils;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Executing @BeforeAll beforeAll()");
    }

    @BeforeEach
    void setup() {
        // Step 1: Create an instance of the class we want to test
        demoUtils = new DemoUtils();
        System.out.println("Running @BeforeEach setup()");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Running @AfterEach tearDown()");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Executing @AfterAll afterAll()");
    }

    @Test
    @DisplayName("Testing for equals and not equals")
    void testEqualsAndNotEquals() {
        System.out.println("Running testEqualsAndNotEquals()");
        int expected = 6;
        int unexpected = 7;

        // Step 2: Call the method we want to test
        int result = demoUtils.addTwoNumbers(3,3);

        // Step 2 & 3: Call our test method within the assertion itself and then assert the value
        assertEquals(expected, demoUtils.addTwoNumbers(3,3), "3 + 3 must be 6");

        // Step 3: Assert the value and verify the result - Without calling test method within the assertion
        assertEquals(expected, result, "3+3 must be 6");
        assertNotEquals(unexpected, result, "3+3 must not be be 6");

    }

    @Test
    void testNullAndNotNull() {
        System.out.println("Running testNullAndNotNull()");
        String expected = null;
        String notNull = "This is NotNull";

        // Step 2 & 3: Call method to be tested within the assertion and then assert the value
        assertNull(demoUtils.checkNull(expected), "Object should be null");
        assertNotNull(demoUtils.checkNull(notNull), "Object should NOT be null");
    }

    @Test
    void testAssertSameNotSame() {
        System.out.println("Running testAssertSame()");
        String str = "Not the same!";
        assertSame(demoUtils.getAcademy(), demoUtils.getAcademyDuplicate(), "Should be the same object!");
        assertNotSame(str, demoUtils.getAcademy(), "Should NOT be the same object!");
    }

    @Test
    void testAssertTrue() {
        System.out.println("Running testAssertTrue()");
        assertTrue(demoUtils.isGreater(10,1), "10 should be greater than 1");
        assertFalse(demoUtils.isGreater(2,10), "2 should NOT be greater than 10");
    }
}
