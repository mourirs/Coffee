package com.coffee.sales.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.coffee.sales.user.dao")
@EnableTransactionManagement
public class CoffeeSalesUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoffeeSalesUserApplication.class, args);
    }

}
