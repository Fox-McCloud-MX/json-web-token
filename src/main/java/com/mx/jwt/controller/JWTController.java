package com.mx.jwt.controller;

import com.mx.jwt.request.JWTRequest;
import com.mx.jwt.response.JWTResponse;
import com.mx.jwt.service.JWTService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@Slf4j
public class JWTController {

    @Autowired
    JWTService jwtService;

    @PostMapping(value = "token", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<JWTResponse> post(@Valid @RequestBody JWTRequest request) {

        log.info("JWTController::POST request {}", request);

        Optional<String> token = Optional.ofNullable(jwtService.getToken(request.getUser(), request.getPassword()));

        JWTResponse jwtResponse = new JWTResponse();
        HttpStatus httpStatus = HttpStatus.OK;

        if (token.isPresent()) {
            jwtResponse.setHasError(false);
            jwtResponse.setError("");
            jwtResponse.setToken(token.get());
        }
        else {
            jwtResponse.setHasError(true);
            jwtResponse.setError("Invalid user or password");
            jwtResponse.setToken("");
            httpStatus = HttpStatus.BAD_REQUEST;
        }

        return ResponseEntity.status(httpStatus).body(jwtResponse);
    }
}
