package com.dallman.udemyjunitmockito;

import com.dallman.udemyjunitmockito.models.CollegeStudent;
import com.dallman.udemyjunitmockito.models.Student;
import com.dallman.udemyjunitmockito.models.StudentGrades;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = UdemyJunitMockitoApplication.class)
public class ReflectionTestUtilsTest {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    CollegeStudent studentOne;

    @Autowired
    StudentGrades studentGrades;

    @BeforeEach
    public void setUp() {
        studentOne.setFirstName("Richard");
        studentOne.setLastName("Smith");
        studentOne.setEmailAddress("rich@smith.com");
        studentOne.setGrades(studentGrades);

        ReflectionTestUtils.setField(studentOne,  "id", 1);
        ReflectionTestUtils.setField(studentOne, "grades",
                new StudentGrades(new ArrayList<>(Arrays.asList(100.0, 85.0, 76.50, 91.75))) {
        });
    }

    @Test
    @DisplayName("Get data from private field")
    public void getDataFromPrivateField() {
        assertEquals(1, ReflectionTestUtils.getField(studentOne, "id"));
    }

    @Test
    @DisplayName("Invoke private method")
    public void invokePrivateMethod() {
        assertEquals("Richard 1",
                ReflectionTestUtils.invokeMethod(studentOne, "getFirstNameAndId"), "This should be Richard 1");
    }

}
