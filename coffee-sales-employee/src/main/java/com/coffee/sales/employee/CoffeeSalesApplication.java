package com.coffee.sales.employee;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.coffee.sales.employee.dao")
@EnableTransactionManagement(proxyTargetClass = true)
@EnableCaching
public class CoffeeSalesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoffeeSalesApplication.class, args);
    }

}
