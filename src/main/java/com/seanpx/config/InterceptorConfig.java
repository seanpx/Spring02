package com.seanpx.config;

import com.seanpx.interceptor.LoginInterceptor;
import com.seanpx.interceptor.LoginInterceptor2;
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

    @Bean  // <-- Define LoginInterceptor as a Spring-managed bean
    public LoginInterceptor2 loginInterceptor2() {
        System.out.println("#PXX InterceptorConfig - Define LoginInterceptor2 as a Spring-managed bean");
        return new LoginInterceptor2();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor())
                .order(1)
                .addPathPatterns("/api/v1/prv/**")  // Apply to specific paths
                .excludePathPatterns("/api/public/**"); // Exclude specific paths

        registry.addInterceptor(loginInterceptor2())
                .order(2)
                .addPathPatterns("/api/v1/prv/**")  // Apply to specific paths
                .excludePathPatterns("/api/public/**"); // Exclude specific paths

        WebMvcConfigurer.super.addInterceptors(registry);
    }

    public LoginInterceptor getLoginInterceptor() {
        return new LoginInterceptor();
    }
}

