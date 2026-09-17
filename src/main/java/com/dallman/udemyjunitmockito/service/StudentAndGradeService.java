package com.dallman.udemyjunitmockito.service;


import com.dallman.udemyjunitmockito.models.CollegeStudent;
import com.dallman.udemyjunitmockito.repository.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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

    public boolean checkIfStudentIsNull(int id) {
        Optional<CollegeStudent> collegeStudent = studentDAO.findById(id);

        if (collegeStudent.isPresent()){
            return true;
        } else return false;
    }

    public void deleteStudent(int id){
        if (checkIfStudentIsNull(id)) {
            studentDAO.deleteById(id);
        }
    }

    public Iterable<CollegeStudent> getGradebook() {
        Iterable<CollegeStudent> collegeStudents = studentDAO.findAll();
        return collegeStudents;
    }
}
