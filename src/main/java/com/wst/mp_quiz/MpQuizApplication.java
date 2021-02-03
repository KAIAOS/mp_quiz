package com.wst.mp_quiz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.wst.mp_quiz.dao")
@SpringBootApplication
public class MpQuizApplication {

    public static void main(String[] args) {
        SpringApplication.run(MpQuizApplication.class, args);
    }

}
