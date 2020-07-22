package com.mx.jwt.controller;

import com.mx.jwt.response.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            path = "/{id}"
    )
    public ResponseEntity<UserResponse> get(@PathVariable String id) {

        UserResponse userResponse = new UserResponse();

        userResponse.setName("dummy_user");
        userResponse.setLastName("dummy_last_name");
        userResponse.setAge(30);

        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
    }

}
