package com.didi.communitysupport;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan("com.didi.dao")
public class CommunitysupportApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommunitysupportApplication.class, args);
    }

}
