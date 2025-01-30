package com.seanpx.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seanpx.domain.User;
import com.seanpx.service.impl.UserServiceImpl;
import com.seanpx.utils.JsonData;
import com.seanpx.utils.ResponseUtil;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.util.StringUtils;

import java.io.IOException;
import java.io.PrintWriter;

/*
   Comment out below @WebFilter in order to test LoginInterceptor
 */
//@WebFilter(urlPatterns = "/api/v1/prv/*", filterName = "loginFilter")
public class LoginFilter implements Filter {

    /* --- Comment out XdClass codes where the Json Response is returned directly from the LoginFilter
               --- Replace with ChatGPT codes as I want define the response method under utils (ResponseUtil) so that it can be reused
    private static final ObjectMapper objectMapper = new ObjectMapper();

     */

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
            JsonData jsonData = JsonData.buildError2("Empty User/Token, Must Login First...", -101);
            /* --- Comment out XdClass codes where the Json Response is returned directly from the LoginFilter
               --- Replace with ChatGPT codes as I want define the response method under utils (ResponseUtil) so that it can be reused
            String jsonStr = objectMapper.writeValueAsString(jsonData);
            renderJson(resp, jsonStr);
             */
            ResponseUtil.renderJson(resp, jsonData);
            return;
        }else {
            //reaching here means the token is not null already, then we should validate whether the token is valid.
            User user = UserServiceImpl.sessionMap.get(token);
            if(user!=null){
                req.setAttribute("loginUser", user);
                filterChain.doFilter(servletRequest,servletResponse);
                return;
            }else {
                JsonData jsonData = JsonData.buildError2("Login Failed, user/token is Invalid...", -102);

                /* --- Comment out XdClass codes where the Json Response is returned directly from the LoginFilter
                   --- Replace with ChatGPT codes as I want define the response method under utils (ResponseUtil) so that it can be reused
                String jsonStr = objectMapper.writeValueAsString(jsonData);
                renderJson(resp, jsonStr);
                 */
                ResponseUtil.renderJson(resp, jsonData);
                return;
            }
        }
    }

    /* --- Comment out XdClass codes where the Json Response is returned directly from the LoginFilter
               --- Replace with ChatGPT codes as I want define the response method under utils (ResponseUtil) so that it can be reused
    private void renderJson(HttpServletResponse response, String json){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        try(PrintWriter writer = response.getWriter()){
            writer.print(json);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

     */

    @Override
    public void destroy() {
        System.out.println("##PXX## filter - destroy");
        Filter.super.destroy();
    }
}
