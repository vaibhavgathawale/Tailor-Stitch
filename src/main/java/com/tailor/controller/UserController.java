package com.tailor.controller;

import com.tailor.model.AuthRequest;
import com.tailor.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping("/hello")
    public String getMSG() {
        return "Welcome Vaibhav....!";
    }

    @PostMapping("/authenticate")
    public String gentareToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
        } catch (Exception e) {
            throw new Exception("Invalid Username or Password");
        }
        return jwtUtil.generateToken(authRequest.getUserName());

    }
}
