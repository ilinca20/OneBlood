package com.ac.OneBlood.logging;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class LoggingFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(LoggingFilter.class);
    public static final String REQUEST_LOG_FORMAT = "correlationId: %s request: method=%s uri=%s";
    public static final String RESPONSE_LOG_FORMAT = "correlationId: %s response: status=%s, uri=%s";
    public static final String CORRELATION_ID_HEADER = "correlationId";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        logger.info(String.format(REQUEST_LOG_FORMAT,
                request.getHeader(CORRELATION_ID_HEADER),
                request.getMethod(),
                request.getRequestURI()));

            filterChain.doFilter(request, response);


        logger.info(String.format(RESPONSE_LOG_FORMAT,
                request.getHeader(CORRELATION_ID_HEADER),
                response.getStatus(),
                request.getRequestURI()));
    }

    @Override
    public void destroy() {
    }


}

