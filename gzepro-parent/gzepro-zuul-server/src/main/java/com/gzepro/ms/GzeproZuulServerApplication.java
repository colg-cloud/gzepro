package com.gzepro.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 
 *
 * @author colg
 */
@EnableZuulProxy
@SpringBootApplication
public class GzeproZuulServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GzeproZuulServerApplication.class, args);
    }
}
