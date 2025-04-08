package com.aressa.aressarestapi.user.service;

import com.aressa.aressarestapi.exception.DuplicateUserException;
import com.aressa.aressarestapi.user.dto.UserDTO;
import com.aressa.aressarestapi.user.model.User;
import com.aressa.aressarestapi.user.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Integer id){
        return userRepository.findById(id);
    }

    public Optional<User> getUserByUser_name(String userName){
        return userRepository.findByUserName(userName);
    }

    public User createUser(User user) {

        if (userRepository.existsByEmail(user.getEmail()).orElse(false)) {
            throw new DuplicateUserException("Email already in use");
        }

        if (userRepository.existsByUserName(user.getUserName()).orElse(false)) {
            throw new DuplicateUserException("Username already taken");
        }

        user.setRegistrationDate(LocalDateTime.now());

        return userRepository.save(user);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
