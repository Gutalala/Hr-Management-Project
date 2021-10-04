package com.group6project.hr.securityfilter;

 
import org.springframework.web.filter.OncePerRequestFilter;

import com.group6project.hr.constants6.Constant;
import com.group6project.hr.util6.JwtUtil;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
    	
    	httpServletResponse.setHeader("Access-Control-Allow-Origin", httpServletRequest.getHeader("Origin"));
    	httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
    	httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
    	httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
    	httpServletResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me");

    	
    	
        String username = JwtUtil.getSubject(httpServletRequest, Constant.JWT_TOKEN_COOKIE_NAME, Constant.SIGNING_KEY);
        if (username == null){
            String authService = this.getFilterConfig().getInitParameter("services.auth");
          //  httpServletResponse.sendRedirect(authService+"?redirect=" + httpServletRequest.getRequestURL());
            
            httpServletResponse.sendRedirect(authService );
        } else {
            httpServletRequest.setAttribute("username", username);
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }
    }
}
