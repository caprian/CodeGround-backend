package com.codeground.codeground.Services.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.codeground.codeground.Models.UserModel.UserModel;
import com.codeground.codeground.dao.UsersDao;

@Service
public class UserService {

    @Autowired
    private UsersDao usersDao;

    public List<UserModel> getAllUsers() {
        return usersDao.findAll();
    }

    public ResponseEntity<String> registerUser(UserModel user) {
        try {
            UserModel existingUser = usersDao.findByEmailId(user.getEmailId());
            if (existingUser != null) {
                return new ResponseEntity<>("Email already in use", HttpStatus.CONFLICT);
            }
            usersDao.save(user);
            return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>("An error occurred while registering the user",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public ResponseEntity<String> authenticateUser(String emailId, String password) {
        UserModel user = usersDao.findByEmailId(emailId);
        if (user != null && user.getPassword().equals(password)) {
            return new ResponseEntity<>("User authenticated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid email or password", HttpStatus.UNAUTHORIZED);
        }
    }

}
