package com.fazliddin.newwarehouse.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Fazliddin Xamdamov
 * @date 18.02.2022  17:37
 * @project New-Warehouse
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationEntryPoint.class);

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        logger.error("Responding with unauthorized error. Message - {}" , authException.getMessage());
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED ,"Kechirasiz bu yo'lga sizni haqqingiz yo'q");
    }
}
