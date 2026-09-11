package com.dallman.udemyjunitmockito.models;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class StudentGrades {

    List<Double> mathGradeResults;

    public StudentGrades() {
        System.out.println("StudentGrades constructor");
    }

    public StudentGrades(List<Double> mathGradeResults) {
        this.mathGradeResults = mathGradeResults;
    }

    public double addGradeResultsForSingleClass(List<Double> grades) {
        double result = 0;
        for (Double grade : grades) {
            result += grade;
        }
        return result;
    }

    public double findGradePointAverage(List<Double> grades) {
        int lengthOfGrades = grades.size();
        double sum = addGradeResultsForSingleClass(grades);
        double result = sum / lengthOfGrades;

        BigDecimal resultRound = BigDecimal.valueOf(result);
        resultRound = resultRound.setScale(2, BigDecimal.ROUND_HALF_UP);

        return resultRound.doubleValue();
    }

    public Boolean isGradeGreater(double gradeOne, double gradeTwo) {
        return gradeOne > gradeTwo;
    }

    public Object checkNull(Object obj) {
        return obj != null ? obj : null;
    }

    public List<Double> getMathGradeResults() {
        return mathGradeResults;
    }

    public void setMathGradeResults(List<Double> mathGradeResults) {
        this.mathGradeResults = mathGradeResults;
    }

    @Override
    public String toString() {
        return "StudentGrades{" +
                "mathGradeResults=" + mathGradeResults +
                '}';
    }
}
