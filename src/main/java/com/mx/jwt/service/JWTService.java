package com.mx.jwt.service;

import com.mx.jwt.security.config.JWTConstants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class JWTService {

    @Autowired
    Environment environment;

    public String getToken(String user, String password) {

        String _user = environment.getProperty("jwt.core.token.user");
        String _password = environment.getProperty("jwt.core.token.password");

        if (!user.equals(_user) && !password.equals(_password)) {
            return  null;
        }

        List grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts.builder().setIssuedAt(new Date()).setIssuer(JWTConstants.ISSUER_INFO)
                .setSubject(user)
                .setExpiration(new Date(System.currentTimeMillis() + JWTConstants.TOKEN_EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, JWTConstants.MD5_SECRET_KEY).compact();

        return JWTConstants.BEARER_TOKEN_PREFIX.concat(token);
    }
}
