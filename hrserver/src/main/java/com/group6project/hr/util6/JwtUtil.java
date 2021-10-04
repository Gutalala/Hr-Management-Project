package com.group6project.hr.util6;

import io.jsonwebtoken.Jwts;

import javax.servlet.http.HttpServletRequest;

public class JwtUtil {

    public static String getSubject(HttpServletRequest httpServletRequest, String jwtCookieName, String signingKey){
        String token = CookieUtil.getValue(httpServletRequest, jwtCookieName);
        if (token == null){
            return null;
        }
        return Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token).getBody().getSubject();
    }

}
