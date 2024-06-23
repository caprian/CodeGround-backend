package com.codeground.codeground.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeground.codeground.Models.UserModel.AuthRequest;
import com.codeground.codeground.Models.UserModel.UserModel;
import com.codeground.codeground.Services.UserService.UserService;

@RestController
@RequestMapping("/auth")
public class UserAuthenticationController {
    @Autowired
    private UserService userAuth;

    @GetMapping("/allusers")
    @CrossOrigin(origins = { "https://codeground-5c6f7.web.app", "http://localhost:3000" })
    public List<UserModel> getAllUserStrings() {
        return userAuth.getAllUsers();
    }

    @PostMapping("/register")
    @CrossOrigin(origins = { "https://codeground-5c6f7.web.app", "http://localhost:3000" })
    public ResponseEntity<String> registerUser(@RequestBody UserModel user) {
        return userAuth.registerUser(user);
    }

    @PostMapping("/login")
    @CrossOrigin(origins = { "https://codeground-5c6f7.web.app", "http://localhost:3000" })
    public ResponseEntity<String> authUsers(@RequestBody AuthRequest authRequest) {
        return userAuth.authenticateUser(authRequest.getEmailId(), authRequest.getPassword());
    }
}
