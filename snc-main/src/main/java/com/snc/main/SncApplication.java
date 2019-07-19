package com.snc.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @version V1.0
 * @Package PACKAGE_NAME
 * @Description: (启动类)
 * @Author Anthony.C
 * @date Created in 下午3:03 2019/7/17
 */
@SpringBootApplication(scanBasePackages = {"com.snc"})
@MapperScan(basePackages={"com.snc.shiro.mapper"})
public class SncApplication {

    public static void main(String[] args) {
        SpringApplication.run(SncApplication.class, args);
    }
}
