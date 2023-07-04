package com.springdemo.ordermanagement.Services;


import com.springdemo.ordermanagement.Exception.ApiRequestException;
import com.springdemo.ordermanagement.model.AuthenticationRequest;
import com.springdemo.ordermanagement.model.AuthenticationResponse;
import com.springdemo.ordermanagement.security.JwtUtil;
import com.springdemo.ordermanagement.security.MyCustomerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class LoginServices {

    @Autowired
    private MyCustomerDetailsService myCustomerDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtTokenUtil;

    public AuthenticationResponse logIn(AuthenticationRequest authenticationRequest) throws ApiRequestException {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new ApiRequestException("Incorrect email or password");
        }
        catch (Exception e){
            throw new ApiRequestException(e.getMessage());
        }

        final UserDetails userDetails = myCustomerDetailsService.loadUserByUsername(authenticationRequest.getEmail());
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        final Date expirationTime = jwtTokenUtil.extractExpiration(jwt);

        return new AuthenticationResponse(jwt,expirationTime, userDetails.getUsername(), userDetails.getAuthorities());
    }


}