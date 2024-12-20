package com.seanpx.filter;

import com.seanpx.domain.User;
import com.seanpx.service.impl.UserServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.util.StringUtils;

import java.io.IOException;

@WebFilter(urlPatterns = "/api/v1/pri/*", filterName = "loginFilter")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("##PXX## filter - LoginFilter - init FilterConfig");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("##PXX## filter - doFilter");

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String token = req.getHeader("token");

        if(StringUtils.isEmpty(token)){
            token = req.getParameter("token");
        }

        if(StringUtils.isEmpty(token)){
            return;
        }else {
            //reaching here means the token is not null already, then we should validate whether the token is valid.
            User user = UserServiceImpl.sessionMap.get(token);
            if(user!=null){
                filterChain.doFilter(servletRequest,servletResponse);
            }
        }
    }

    @Override
    public void destroy() {
        System.out.println("##PXX## filter - destroy");
        Filter.super.destroy();
    }
}
