package com.aressa.aressarestapi.user.repository;

import com.aressa.aressarestapi.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String userName);
    Optional<Boolean> existsByEmail(String email);
    Optional<Boolean> existsByUserName(String userName);
}
