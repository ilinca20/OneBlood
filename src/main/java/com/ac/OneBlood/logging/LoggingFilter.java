package com.ac.OneBlood.logging;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoggingFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(LoggingFilter.class);
    public static final String REQUEST_LOG_FORMAT = "correlationId: %s request: method=%s uri=%s";
    public static final String RESPONSE_LOG_FORMAT = "correlationId: %s response: status=%s, uri=%s";
    public static final String CORRELATION_ID_HEADER = "correlationId";

    @Override
    public void init(FilterConfig filterConfig) {}

    @Override
    public void doFilter(jakarta.servlet.ServletRequest servletRequest, jakarta.servlet.ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        logger.info(String.format(REQUEST_LOG_FORMAT,
                request.getHeader(CORRELATION_ID_HEADER),
                request.getMethod(),
                request.getRequestURI()));


        chain.doFilter(request, response);


        logger.info(String.format(RESPONSE_LOG_FORMAT,
                request.getHeader(CORRELATION_ID_HEADER),
                response.getStatus(),
                request.getRequestURI()));
    }

    @Override
    public void destroy() {
    }
}

