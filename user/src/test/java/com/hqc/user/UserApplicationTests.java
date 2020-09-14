package com.hqc.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserApplicationTests {

    @Autowired
    private Book book;

    @Value("${book.name}")
    String name;

    @Value("${book.author}")
    String author;

    @Test
    void contextLoads() {
        System.out.println(name + author);
    }

}
