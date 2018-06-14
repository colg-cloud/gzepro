package com.gzepro.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

import tk.mybatis.spring.annotation.MapperScan;

/**
 * Spring Boot 启动类
 * 
 * <pre>
 * '@SpringCloudApplication'：           启动后发现客户端，并开启对 hystrix 熔断机制的支持
 * '@EnableFeignClients'：               开启 Feign 功能，rest 通信
 * </pre>
 *
 * @author colg
 */
@EnableFeignClients
@EnableEurekaClient
@MapperScan("com.gzepro.ms.mapper")
@SpringCloudApplication
public class GzeproManageService {

    public static void main(String[] args) {
        SpringApplication.run(GzeproManageService.class, args);
    }
}
