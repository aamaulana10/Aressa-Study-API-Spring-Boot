package com.aressa.aressarestapi.user.service;

import com.aressa.aressarestapi.user.model.User;
import com.aressa.aressarestapi.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Integer id){
        return userRepository.findById(id);
    }

    public Optional<User> getUserByUser_name(String username){
        return userRepository.findByUsername(username);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
