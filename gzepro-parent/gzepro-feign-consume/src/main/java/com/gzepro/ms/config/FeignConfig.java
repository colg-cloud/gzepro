package com.gzepro.ms.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.http.Header;
import feign.Feign;
import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * feign 配置
 *
 * @author colg
 */
@Configuration
public class FeignConfig {

    @Bean
    public Feign.Builder builder() {
        return Feign.builder().requestInterceptor(new RequestInterceptor() {

            @Override
            public void apply(RequestTemplate template) {
                ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
                HttpServletRequest request = attributes.getRequest();
                // 忽略大小写获取 header 中的信息
                String language = Header.ACCEPT_LANGUAGE.toString();
                String header = ServletUtil.getHeaderIgnoreCase(request, language);
                // 设置语言
                if (StrUtil.isNotBlank(header)) {
                    template.header(language, header);
                }
            }
        });
    }
}
