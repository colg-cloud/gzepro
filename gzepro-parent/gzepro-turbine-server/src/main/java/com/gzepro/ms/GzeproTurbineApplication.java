package com.gzepro.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * Spirng Boot 启动类
 * 
 * <pre>
 * `@EnableTurbine`：   启用 Turbine 来对服务的 Hystrix 数据进行聚合展示
 * </pre>
 * 
 * @author colg
 */
@EnableTurbine
@EnableEurekaClient
@SpringBootApplication
public class GzeproTurbineApplication {

    public static void main(String[] args) {
        SpringApplication.run(GzeproTurbineApplication.class, args);
    }
}
