package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-jdbc-druid
 * @package: com.test
 * @email: cy880708@163.com
 * @date: 2018/8/21 下午3:15
 * @mofified By:
 */
@SpringBootApplication
@EnableAsync
@EnableScheduling
public class StartApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }
}
