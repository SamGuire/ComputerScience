package com.example.ormsandbox.configuration.jwt;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.ormsandbox.repository.user.IUserRepository;
import com.example.ormsandbox.utility.jwt.JWTTokenUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
public class JWTFilter implements Filter {

    @Autowired
    IUserRepository userRepository;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Cookie[] cookies = ((HttpServletRequest) request).getCookies();
        HttpServletResponse res = (HttpServletResponse) response;
        if (cookies == null) {
            chain.doFilter(request, response);
        } else {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("jwtToken")) {
                    try {
                        DecodedJWT decoded = JWTTokenUtil.verifyToken(cookie.getValue());
                        UUID userId = UUID.fromString(decoded.getClaim("userId").asString());
                        UserDetails userDetails = userRepository.findByUserId(userId);
                        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities()));
                        chain.doFilter(request, response);
                    } catch (JWTVerificationException exception) {
                        chain.doFilter(request,response);
                    }
                }
            }
        }
    }
}
