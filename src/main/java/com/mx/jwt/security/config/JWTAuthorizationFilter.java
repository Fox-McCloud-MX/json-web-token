package com.mx.jwt.security.config;

import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;


public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
    public JWTAuthorizationFilter(AuthenticationManager authManager) {
        super(authManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        String header = req.getHeader(JWTConstants.HEADER_AUTHORIZATION_KEY);
        if (!Optional.ofNullable(header).isPresent()  || !header.startsWith(JWTConstants.BEARER_TOKEN_PREFIX)) { //TODO
            chain.doFilter(req, res);
            return;
        }
        UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(req, res);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(JWTConstants.HEADER_AUTHORIZATION_KEY);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = null;
        if (Optional.ofNullable(token).isPresent()) {
            String user = Jwts.parser()
                    .setSigningKey(JWTConstants.MD5_SECRET_KEY)
                    .parseClaimsJws(token.replace(JWTConstants.BEARER_TOKEN_PREFIX, ""))
                    .getBody()
                    .getSubject();

            if (Optional.ofNullable(user).isPresent()) {
                usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        user,
                        null,
                        new ArrayList<>()
                );
            }
        }
        return usernamePasswordAuthenticationToken;
    }

}
