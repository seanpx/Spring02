package com.seanpx.interceptor;  // Adjust the package name as per your project structure

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor2 implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("LoginInterceptor2 - preHandle invoked.");
        // Add your custom logic here, e.g., additional authentication checks,
        // logging, header validations, etc.



        // Return true to continue the processing, false to block the request.
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("#PXX# LoginInterceptor2 - postHandle");

        HandlerInterceptor.super.postHandle(request, response,handler,modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("#PXX# LoginInterceptor2 - afterCompletion");

        HandlerInterceptor.super.afterCompletion(request, response,handler, ex);
    }
    // You can also override postHandle and afterCompletion if needed.
}
