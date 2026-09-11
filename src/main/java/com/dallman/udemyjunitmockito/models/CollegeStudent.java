package com.dallman.udemyjunitmockito.models;

//Colleage student is not marked as a @Component but in our application we manually create a bean
public class CollegeStudent implements Student{

    private String firstName;
    private String lastName;
    private String emailAddress;
    private StudentGrades grades;

    public CollegeStudent() {
    }

    public CollegeStudent(String firstName, String lastName, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public StudentGrades getGrades() {
        return grades;
    }

    public void setGrades(StudentGrades grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        return "CollegeStudent{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }

    @Override
    public String studentInformation() {
        return getFullName() + " " + getEmailAddress();
    }

    @Override
    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }
}
