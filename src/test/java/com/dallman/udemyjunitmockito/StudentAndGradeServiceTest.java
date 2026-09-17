package com.dallman.udemyjunitmockito;

import com.dallman.udemyjunitmockito.models.CollegeStudent;
import com.dallman.udemyjunitmockito.repository.StudentDAO;
import com.dallman.udemyjunitmockito.service.StudentAndGradeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = UdemyJunitMockitoApplication.class)
@TestPropertySource("/.env-uat.properties")
public class StudentAndGradeServiceTest {

    @Autowired
    StudentAndGradeService studentAndGradeService;

    @Autowired
    StudentDAO studentDAO;


    @Test
    @DisplayName("Create Student service")
    public void createStudentService() {
        studentAndGradeService.createStudent("Richard", "Dallman", "rich@test.com");

        CollegeStudent student = studentDAO.findByEmailAddress("rich@test.com");

        assertEquals("rich@test.com", student.getEmailAddress(), "Should be \"rich@test.com\"");
    }

}
