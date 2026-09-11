package com.dallman.udemyjunitmockito;

import com.dallman.udemyjunitmockito.models.CollegeStudent;
import com.dallman.udemyjunitmockito.models.StudentGrades;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UdemyJunitMockitoApplicationTests {

    private static int count = 0;

    @Value("${info.app.description}")
    private String appDescription;

    @Autowired
    CollegeStudent collegeStudent;

    @Autowired
    StudentGrades studentGrades;

    @Autowired
    ApplicationContext applicationContext;

    @BeforeEach
    public void beforeEach() {
        count++;
        System.out.println("App description " + appDescription);
        System.out.println("Execution count " + count);

        collegeStudent.setFirstName("Richard");
        collegeStudent.setLastName("Dallman");
        collegeStudent.setEmailAddress("rich@dallman.com");
        studentGrades.setMathGradeResults(new ArrayList<>(Arrays.asList(100.0, 85.0, 76.50, 91.75)));
        collegeStudent.setGrades(studentGrades);
    }

    @Test
    void contextLoads() {
    }

    @Test
    @DisplayName("Testing the application version")
    void testAppVersion(@Value("${info.app.version}") String version) {
        assertEquals("1.0.0", version, "Should be version 1.0.0");
    }

    @Test
    @DisplayName("Testing the application description")
    void testAppDescription() {
        String expected = "JUnit and Mockito testing";
        assertEquals(expected, appDescription, "Should be the description of Unit and Mockito testing");
    }

    @Test
    @DisplayName("Add grade results for student grades")
    public void addGradeResultsForStudentGrades() {
        assertEquals(353.25, studentGrades.addGradeResultsForSingleClass(
                collegeStudent.getGrades().getMathGradeResults()
        ));
    }

    @Test
    @DisplayName("Add grade results for student grades ! equal")
    public void addGradeResultsForStudentGradesAssertNotEquals() {
        assertNotEquals(0, studentGrades.addGradeResultsForSingleClass(
                collegeStudent.getGrades().getMathGradeResults()
        ));
    }

    @Test
    @DisplayName("Is grade greater?")
    public void isGradeGreaterAssertTrue() {
        assertTrue(studentGrades.isGradeGreater(10, 1), "Grade one should be greater than grade two");
    }

    @Test
    @DisplayName("Is grade greater false?")
    public void isGradeGreaterAssertFalse() {
        assertFalse(studentGrades.isGradeGreater(1, 10), "Grade one should be less than grade two");
    }

    @Test
    @DisplayName("Checking of null values")
    public void checkNullValues() {
        assertNotNull(studentGrades.checkNull(collegeStudent.getGrades().getMathGradeResults()), "Object should not be null");
    }

    @Test
    @DisplayName("Create student without grade init")
    public void createStudentWithoutGradesInit() {
        //@Autowired the application context to make use of context.getBean()
        CollegeStudent studentTwo = applicationContext.getBean("collegeStudent", CollegeStudent.class);
        studentTwo.setFirstName("Em");
        studentTwo.setLastName("vDV");
        studentTwo.setEmailAddress("em@vDV.com");
        assertNotNull(studentTwo.getFirstName());
        assertNotNull(studentTwo.getLastName());
        assertNotNull(studentTwo.getEmailAddress());
        assertNull(studentGrades.checkNull(studentTwo.getGrades()));
    }

    @Test
    @DisplayName("Verify students are prototypes")
    //Manually created CollegeStudent Bean in the UdemyJunitMocktioApplication class sets the value of the Bean to "prototype"
    public void verifyStudentsArePrototypes() {
        CollegeStudent studentTwo = applicationContext.getBean("collegeStudent", CollegeStudent.class);
        //The collegeStudent here is autowired
        assertNotSame(collegeStudent, studentTwo);
    }

    @Test
    @DisplayName("Find grade point average")
    public void findGradePointAverage() {
        //Combine multiple asserts into one
        assertAll("Testing all assertEquals",
                () -> assertEquals(353.25,
                        studentGrades.addGradeResultsForSingleClass(collegeStudent.getGrades().getMathGradeResults())),
                () -> assertEquals(88.31, studentGrades.findGradePointAverage(
                        collegeStudent.getGrades().getMathGradeResults()))
        );
    }

}
