package com.aressa.aressarestapi.user.controller;

import com.aressa.aressarestapi.exception.ResourceNotFoundException;
import com.aressa.aressarestapi.user.dto.UserDTO;
import com.aressa.aressarestapi.user.model.User;
import com.aressa.aressarestapi.user.service.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping( "/api/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<User> getAllUser(){
        logger.info("Fetching all users");
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " not found"));
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO) {

        User user = modelMapper.map(userDTO, User.class);
        User savedUser = userService.createUser(user);

        UserDTO responseDTO = modelMapper.map(savedUser, UserDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
