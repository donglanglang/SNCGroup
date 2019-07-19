package com.snc.shiro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

/**
 * @version V1.0
 * @Package com.snc.shiro.config
 * @Description: (该类配置Shiro未授权跳转)
 * @Author Anthony.C
 * @date Created in 下午5:41 2019/7/18
 */
@Configuration
public class ExceptionConf {
    @Bean
    public SimpleMappingExceptionResolver resolver() {
        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
        Properties properties = new Properties();
        properties.setProperty("org.apache.shiro.authz.UnauthorizedException", "/403");
        resolver.setExceptionMappings(properties);
        return resolver;
    }
}
