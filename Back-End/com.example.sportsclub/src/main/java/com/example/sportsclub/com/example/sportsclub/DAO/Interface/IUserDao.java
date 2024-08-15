package com.example.sportsclub.com.example.sportsclub.DAO.Interface;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.sportsclub.com.example.sportsclub.Entity.User;

@Repository
public interface IUserDao {
    List<User> getAll();

    void add(User user);

    void update(User user);

    void delete(User user);

    User getById(Long id);

    User getByEmail(String email);

    User getByUsername(String username);

    List<User> getAllByRole(String role);

    boolean login(String username, String password);

    boolean isAdmin(String username);

    void updateStatusTo(Long id, boolean status);

    void updateAllUsersStatusToFalse();

}
