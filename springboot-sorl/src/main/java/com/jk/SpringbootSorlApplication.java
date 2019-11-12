package com.jk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
//@MapperScan("com.jk.mapper")
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class SpringbootSorlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSorlApplication.class, args);
    }

}
