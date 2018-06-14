package com.gzepro.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Spring Boot 启动类
 * 
 * <pre>
 * '@EnableConfigServer'：               开启 分布式配置服务中心
 * </pre>
 *
 * @author colg
 */
@EnableEurekaClient
@EnableConfigServer
@SpringBootApplication
public class GzeproConfigService {

    public static void main(String[] args) {
        SpringApplication.run(GzeproConfigService.class, args);
    }
}
