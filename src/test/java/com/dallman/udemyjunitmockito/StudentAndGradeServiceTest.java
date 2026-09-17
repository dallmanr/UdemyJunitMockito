package com.dallman.udemyjunitmockito;

import com.dallman.udemyjunitmockito.models.CollegeStudent;
import com.dallman.udemyjunitmockito.repository.StudentDAO;
import com.dallman.udemyjunitmockito.service.StudentAndGradeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = UdemyJunitMockitoApplication.class)
@TestPropertySource("/.env-uat.properties")
public class StudentAndGradeServiceTest {

    @Autowired
    StudentAndGradeService studentAndGradeService;

    @Autowired
    StudentDAO studentDAO;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    void setUpDatabase() {
        // A 'known' state. We insert data we know exists in order to test against it
        jdbcTemplate.execute("insert into student(firstname, lastname, email_address)" +
                "values ('John', 'Doe', 'john@doe.com')");
    }

    @AfterEach
    void cleanDatabase() {
        // Once we finish with a test, we remove the data to clean it up
        jdbcTemplate.execute("delete from student"); // Remove the student
        jdbcTemplate.execute("ALTER TABLE student ALTER COLUMN ID RESTART WITH 1"); // Reset the primary key
    }


    @Test
    @DisplayName("Create Student service")
    public void createStudentService() {
        studentAndGradeService.createStudent("Richard", "Dallman", "rich@test.com");

        CollegeStudent student = studentDAO.findByEmailAddress("rich@test.com");

        assertEquals("rich@test.com", student.getEmailAddress(), "Should be \"rich@test.com\"");
    }

    @Test
    @DisplayName("Is Student null check")
    public void isStudentNullCheck() {
        assertTrue(studentAndGradeService.checkIfStudentIsNull(11));

        assertFalse(studentAndGradeService.checkIfStudentIsNull(0));
    }

    @Test
    @DisplayName("Delete Student using Student service")
    public void deleteStudentService() {
        //Check we have the student first and that it exists
        Optional<CollegeStudent> collegeStudent = studentDAO.findById(1);
        assertTrue(collegeStudent.isPresent());

        // Delete the student
        studentAndGradeService.deleteStudent(1);
        // Try finding the student again, it should be removed at this stage
        collegeStudent = studentDAO.findById(1);
        // Check the student does NOT exist
        assertFalse(collegeStudent.isPresent());
    }

    @Test
    @DisplayName("Get grade book service")
    @Sql("/insertData.sql")
    public void getGradeBookService() {
        Iterable<CollegeStudent> iterableCollegeStudents = studentAndGradeService.getGradebook();

        List<CollegeStudent> collegeStudents = new ArrayList<>();

        for (CollegeStudent collegeStudent : iterableCollegeStudents) {
            collegeStudents.add(collegeStudent);
        }
        // @BeforeEach we only add 1 college student so this should be == 1
        assertEquals(5, collegeStudents.size());
    }

}
