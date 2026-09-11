package com.dallman.udemyjunitmockito;

import com.dallman.udemyjunitmockito.models.CollegeStudent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class UdemyJunitMockitoApplication {

    public static void main(String[] args) {
        SpringApplication.run(UdemyJunitMockitoApplication.class, args);
    }

    //We don't need to add the @Component annotation to CollegeStudent because we manually define the bean here
    @Bean(name="collegeStudent")
    @Scope(value="prototype")
    CollegeStudent getCollegeStudent() {return new CollegeStudent();}

}
