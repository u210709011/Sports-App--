package com.example.sportsclub.com.example.sportsclub.Business.Interface;

import java.util.List;

import com.example.sportsclub.com.example.sportsclub.Entity.User;

public interface IUserService {
    List<User> getAll();

    void add(User user);

    void update(User user);

    void delete(User user);

    User getById(Long id);

    List<User> getAllByRole(String role);

    User getByUsername(String username);

    User getByEmail(String email);

    boolean login(String username, String password);

    boolean isAdmin(String username);

    void updateStatusTo(Long id, boolean status);

}