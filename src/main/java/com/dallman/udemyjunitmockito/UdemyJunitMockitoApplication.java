package com.dallman.udemyjunitmockito;

import com.dallman.udemyjunitmockito.dao.ApplicationDAO;
import com.dallman.udemyjunitmockito.models.CollegeStudent;
import com.dallman.udemyjunitmockito.service.ApplicationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class UdemyJunitMockitoApplication {

    public static void main(String[] args) {
        SpringApplication.run(UdemyJunitMockitoApplication.class, args);
    }
}
