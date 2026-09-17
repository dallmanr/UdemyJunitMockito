package com.dallman.udemyjunitmockito.service;


import com.dallman.udemyjunitmockito.models.CollegeStudent;
import com.dallman.udemyjunitmockito.models.Student;
import com.dallman.udemyjunitmockito.repository.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentAndGradeService {

    @Autowired
    StudentDAO studentDAO;

    public void createStudent(String firstName, String lastName, String emailAddress){
        CollegeStudent collegeStudent = new CollegeStudent(firstName, lastName, emailAddress);
        collegeStudent.setId(0);
        studentDAO.save(collegeStudent);
    }
}
