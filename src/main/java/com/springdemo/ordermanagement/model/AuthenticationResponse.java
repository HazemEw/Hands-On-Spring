package com.springdemo.ordermanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {

    private String jwt;
    private Date expirationTime;
    private String email;
    private Collection<?> authorities;

}