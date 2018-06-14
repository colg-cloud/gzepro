package com.gzepor.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Spring Boot 启动类
 * 
 * <pre>
 * '@EnableEurekaServer'：   服务端启动类，接收其他微服务注册进来
 * </pre>
 *
 * @author colg
 */
@EnableEurekaServer
@SpringBootApplication
public class GzeporEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GzeporEurekaServerApplication.class, args);
    }
}
