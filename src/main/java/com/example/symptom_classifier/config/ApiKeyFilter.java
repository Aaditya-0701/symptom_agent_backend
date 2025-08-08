package com.example.symptom_classifier.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

@Component
public class ApiKeyFilter implements Filter {
    @Value("${api.key}")
    private String apiKey;


    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        String key = request.getHeader("Authorization");
        if (!("Bearer " + apiKey).equals(key)) {
            ((HttpServletResponse) res).sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        System.out.println(apiKey);
        chain.doFilter(req, res);
    }
}
