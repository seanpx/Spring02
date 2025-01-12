package com.seanpx.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;

public class ResponseUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void renderJson(HttpServletResponse response, Object obj) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        try (PrintWriter writer = response.getWriter()) {
            String jsonStr = objectMapper.writeValueAsString(obj);
            writer.print(jsonStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

