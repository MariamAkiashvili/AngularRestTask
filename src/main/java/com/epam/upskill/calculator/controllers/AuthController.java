package com.epam.upskill.calculator.controllers;

import com.epam.upskill.calculator.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class AuthController {


    @PostMapping("/Auth")
    public ResponseEntity<?> authentification(@RequestBody String username){
        String userToken = JwtUtil.generateToken(username);
        return ResponseEntity.status(HttpStatus.OK).body(userToken);
    }
}
