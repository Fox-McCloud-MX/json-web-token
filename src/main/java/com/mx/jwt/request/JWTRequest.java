package com.mx.jwt.request;

import lombok.Data;

@Data
public class JWTRequest {
    private String user;
    private String password;
}
