package com.gzepro.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import tk.mybatis.spring.annotation.MapperScan;

/**
 * Spring Boot 启动类
 * 
 * <pre>
 * '@SpringCloudApplication'：           启动后发现客户端，并开启对 hystrix 熔断机制的支持
 * </pre>
 *
 * @author colg
 */
@EnableEurekaClient
@MapperScan("com.gzepro.ms.mapper")
@SpringCloudApplication
public class GzeproEvaluateService {

    public static void main(String[] args) {
        SpringApplication.run(GzeproEvaluateService.class, args);
    }
}
