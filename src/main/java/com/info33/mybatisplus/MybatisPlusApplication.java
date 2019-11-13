package com.info33.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.info33.mybatisplus.dao")
public class MybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusApplication.class, args);

//        SpringApplicationBuilder builder = new SpringApplicationBuilder(MybatisPlusApplication.class);
        //修改Banner的模式为OFF
//        builder.bannerMode(Banner.Mode.OFF).run(args);
    }

}
