package com.seanpx.config;

import com.seanpx.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean  // <-- Define LoginInterceptor as a Spring-managed bean
    public LoginInterceptor loginInterceptor() {
        System.out.println("#PXX InterceptorConfig - Define LoginInterceptor as a Spring-managed bean");
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getLoginInterceptor())
                .addPathPatterns("/api/v1/prv/**")  // Apply to specific paths
                .excludePathPatterns("/api/public/**"); // Exclude specific paths

        WebMvcConfigurer.super.addInterceptors(registry);
    }

    public LoginInterceptor getLoginInterceptor() {
        return new LoginInterceptor();
    }
}

