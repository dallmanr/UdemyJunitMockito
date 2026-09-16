package com.dallman.udemyjunitmockito;

import com.dallman.udemyjunitmockito.dao.ApplicationDAO;
import com.dallman.udemyjunitmockito.models.CollegeStudent;
import com.dallman.udemyjunitmockito.models.StudentGrades;
import com.dallman.udemyjunitmockito.service.ApplicationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.DoNotMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = UdemyJunitMockitoApplication.class)
public class MockAnnotationTest {

    @MockitoBean // Create our Test Double - Adds the given bean to the app context
    private ApplicationDAO applicationDAO;

    @Autowired // Inject the service into our app context
    private ApplicationService applicationService;

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    CollegeStudent studentOne;

    @Autowired
    StudentGrades studentGrades;

    @BeforeEach
    public void beforeEach() {
        studentOne.setFirstName("Rich");
        studentOne.setLastName("Dallman");
        studentOne.setEmailAddress("rich@dallman.com");
        studentOne.setGrades(studentGrades);
    }

    @Test
    void contextLoads() {
    }

    @Test
    @DisplayName("When & Verify")
    void assertEqualsTestAddGrades() {
        // 1. Create the expectation - When addGradeResultsForSingleClass is called then return 100
        when(applicationDAO.addGradeResultsForSingleClass(studentGrades.getMathGradeResults()))
                .thenReturn(100.00);

        // 2. Assert
        assertEquals(100, applicationService.addGradeResultsForSingleClass(studentOne.getGrades().getMathGradeResults()));

        // 3. Verify
        verify(applicationDAO).addGradeResultsForSingleClass(studentGrades.getMathGradeResults());
        // 3b. Verify the method call was made 3x during the test
        verify(applicationDAO, times(1)).addGradeResultsForSingleClass(studentGrades.getMathGradeResults());
    }

    @Test
    @DisplayName("Find GPA")
    void assertEqualsTestFindGPA() {
        // 1. Create the expectation - When findGradePointAverage is called, then return 88.31
        when(applicationDAO.findGradePointAverage(studentGrades.getMathGradeResults())).thenReturn(88.31);

        // 2. Assert
        assertEquals(88.31, applicationService.findGradePointAverage(studentGrades.getMathGradeResults()));

        // 3. Verify the method was called at least once
        verify(applicationDAO, times(1)).findGradePointAverage(studentGrades.getMathGradeResults());
    }

    @Test
    @DisplayName("Check Not Null")
    void testAssertNotNull() {
        // 1. Create the expectation - Checking student grades is not null
        when(applicationDAO.checkNull(studentGrades.getMathGradeResults())).thenReturn(true);

        // 2. Assert
        assertNotNull(applicationService.checkNull(studentOne.getGrades().getMathGradeResults()), "Object should not be null");

        // 3. Verify method was called at least once
        verify(applicationDAO, times(1)).checkNull(studentGrades.getMathGradeResults());
    }
}
