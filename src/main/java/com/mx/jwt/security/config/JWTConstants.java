package com.mx.jwt.security.config;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

public class JWTConstants {
    // Spring Security
    public static final String HEADER_AUTHORIZATION_KEY = HttpHeaders.AUTHORIZATION;
    public static final String BEARER_TOKEN_PREFIX = "Bearer ";

    // JWT
    public static final String ISSUER_INFO = "json-web-token";
    private static final String SECRET_KEY = "E!2ncl@7tF$T";
    public static final String MD5_SECRET_KEY = "1aeffa8c580194cdc4ecfd1969cfec98";
    private static final int EXPIRATION_TOKEN_IN_MINUTES = 15;
    public static final long TOKEN_EXPIRATION_TIME = TimeUnit.MINUTES.toMillis(EXPIRATION_TOKEN_IN_MINUTES);

    public static final List<String> ALLOWED_HEADERS = Arrays.asList(
            "X-Requested-With",
            HttpHeaders.ORIGIN,
            HttpHeaders.CONTENT_TYPE,
            HttpHeaders.ACCEPT,
            HttpHeaders.AUTHORIZATION,
            HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS,
            HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS,
            HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS,
            HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN,
            HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS,
            HttpHeaders.ACCESS_CONTROL_MAX_AGE,
            HttpHeaders.ACCESS_CONTROL_REQUEST_HEADERS,
            HttpHeaders.ACCESS_CONTROL_REQUEST_METHOD,
            HttpHeaders.AGE,
            HttpHeaders.ALLOW,
            "Alternates",
            HttpHeaders.CONTENT_RANGE,
            HttpHeaders.CONTENT_DISPOSITION,
            "Content-Description"
    );

    public static final List<String> ALLOWED_METHODS = Arrays.asList(
            HttpMethod.DELETE.toString(),
            HttpMethod.GET.toString(),
            HttpMethod.POST.toString(),
            HttpMethod.PATCH.toString(),
            HttpMethod.PUT.toString()
    );

    public static final List<String> ALLOWED_ORIGINS = Arrays.asList("*");

    public static final List<String> EXPOSE_HEADERS = Arrays.asList(
            HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS,
            HttpHeaders.AUTHORIZATION,
            "x-xsrf-token",
            HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS,
            HttpHeaders.ORIGIN,
            HttpHeaders.ACCEPT,
            "X-Requested-With",
            HttpHeaders.CONTENT_TYPE,
            HttpHeaders.ACCESS_CONTROL_REQUEST_HEADERS,
            HttpHeaders.ACCESS_CONTROL_REQUEST_METHOD
    );

    public static final String[] ALLOWED_URL = {
            "/token**",
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**"
    };

    public static final String[] NOT_ALLOWED_URL = {
            "/user**"
    };
}
