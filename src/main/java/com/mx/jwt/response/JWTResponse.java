package com.mx.jwt.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class JWTResponse {

    @JsonProperty("token")
    private String token;

    @JsonProperty("hasError")
    private Boolean hasError;

    @JsonProperty("error")
    private String error;

}
