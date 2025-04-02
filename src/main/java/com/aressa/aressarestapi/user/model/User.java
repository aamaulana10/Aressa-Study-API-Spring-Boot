package com.aressa.aressarestapi.user.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;

    @Column(name = "user_name", nullable = false, unique = true)
    private String  username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String dob;

    @Column(nullable = false)
    private String created_at;

    @Column(nullable = false)
    private String updated_at;

    public User() {}

    public User(String username, String email, String password, String dob, String created_at, String updated_at) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getDob() {
        return dob;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }
}
