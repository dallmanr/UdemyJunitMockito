package com.dallman.udemyjunitmockito;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UdemyJunitMockitoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void basicTest(@Value("${info.app.version}") String version){
        assertEquals("1.0.0", version, "Should be version 1.0.0");
    }

}
