package com.seanpx.interceptor;

import com.seanpx.domain.User;
import com.seanpx.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, @NotNull HttpServletResponse response, Object handler) throws Exception {
        System.out.println("#PXX# LoginInterceptor - preHandle");

        String token = request.getHeader("token");
        System.out.println("#PXX# Extracted Token: " + token);

        if (token == null || token.isEmpty()) {
            System.out.println("#PXX# No token found in the request.");
            response.getWriter().write("{\"code\": -1, \"msg\": \"No token found in request header\"}");
            return false;
        }

        // Check if user exists in sessionMap
        User user = UserServiceImpl.sessionMap.get(token);  // <-- Fetch from static map instead of session

        if (user == null) {
            System.out.println("#PXX# No user found in sessionMap for token: " + token);
            response.getWriter().write("{\"code\": -1, \"msg\": \"Not authenticated. No user found.\"}");
            return false;
        }

        System.out.println("#PXX# User authenticated: " + user.getUsername());
        request.setAttribute("loginUser", user);  // <-- Forward the user to controller
        //return true;
        return HandlerInterceptor.super.preHandle(request,response,handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("#PXX# LoginInterceptor - postHandle");

        HandlerInterceptor.super.postHandle(request, response,handler,modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("#PXX# LoginInterceptor - afterCompletion");

        HandlerInterceptor.super.afterCompletion(request, response,handler, ex);
    }

}
