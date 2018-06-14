package com.gzepro.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Spring Boot 启动类
 * 
 * <pre>
 * '@EnableEurekaClient'：               启动后自动注册进eureka服务中（就是如果选用的注册中心是eureka，那么就推荐@EnableEurekaClient）
 * '@EnableFeignClients'：               开启 Feign 功能，rest 通信
 * </pre>
 *
 * @author colg
 */
@EnableFeignClients
@EnableEurekaClient
@SpringCloudApplication
public class GzeproHistoryService {

    public static void main(String[] args) {
        SpringApplication.run(GzeproHistoryService.class, args);
    }
}
