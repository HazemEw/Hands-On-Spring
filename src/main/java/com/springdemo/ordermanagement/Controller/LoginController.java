package com.springdemo.ordermanagement.Controller;

import com.springdemo.ordermanagement.Exception.ApiRequestException;
import com.springdemo.ordermanagement.Services.LoginServices;
import com.springdemo.ordermanagement.model.AuthenticationRequest;
import com.springdemo.ordermanagement.model.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
public class LoginController {

    @Autowired
    LoginServices loginService;

    @PostMapping("")
    public AuthenticationResponse LogIn(@RequestBody AuthenticationRequest authenticationRequest) throws ApiRequestException {
        return loginService.logIn(authenticationRequest);
    }
}