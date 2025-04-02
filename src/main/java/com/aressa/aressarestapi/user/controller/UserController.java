package com.aressa.aressarestapi.user.controller;

import com.aressa.aressarestapi.user.model.User;
import com.aressa.aressarestapi.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/api/user")
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = userService.createUser(user);
        return ResponseEntity.ok(newUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
