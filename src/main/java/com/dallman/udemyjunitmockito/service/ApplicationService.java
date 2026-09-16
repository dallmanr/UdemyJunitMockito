package com.dallman.udemyjunitmockito.service;

import com.dallman.udemyjunitmockito.dao.ApplicationDAO;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

public class ApplicationService {

    @Autowired
    private ApplicationDAO applicationDAO;

    public double addGradeResultsForSingleClass(List<Double> numbers) {
        return applicationDAO.addGradeResultsForSingleClass(numbers);
    }

    public double findGradePointAverage (List<Double> grades ) {
        return applicationDAO.findGradePointAverage(grades);
    }

    public Object checkNull(Object obj) {
        return applicationDAO.checkNull(obj);
    }

}