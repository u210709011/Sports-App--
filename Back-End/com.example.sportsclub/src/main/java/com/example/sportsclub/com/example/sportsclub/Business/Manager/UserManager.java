package com.example.sportsclub.com.example.sportsclub.Business.Manager;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sportsclub.com.example.sportsclub.Business.Interface.IUserService;
import com.example.sportsclub.com.example.sportsclub.DAO.Interface.IUserDao;
import com.example.sportsclub.com.example.sportsclub.Entity.User;

@Service
public class UserManager implements IUserService {
    IUserDao userDao;

    public UserManager(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public List<User> getAll() {
        return this.userDao.getAll();
    }

    @Override
    @Transactional
    public void add(User user) {
        if (this.userDao.getByEmail(user.getEmail()) == null && this.userDao.getByUsername(user.getUsername()) == null) {
            this.userDao.add(user);
        }
    }

    @Override
    @Transactional
    public void update(User user) {
        this.userDao.update(user);
    }

    @Override
    @Transactional
    public void delete(User user) {
        this.userDao.delete(user);
    }

    @Override
    @Transactional
    public User getById(Long id) {
        return this.userDao.getById(id);
    }

    @Override
    public List<User> getAllByRole(String role) {
        return this.userDao.getAllByRole(role);
    }

    @Override
    public User getByUsername(String username) {
        return this.userDao.getByUsername(username);
    }

    @Override
    public User getByEmail(String email) {
        return this.userDao.getByEmail(email);
    }

    @Override
    public boolean login(String username, String password) {
        return userDao.login(username, password);
    }

    @Override
    public boolean isAdmin(String username) {
        return userDao.isAdmin(username);
    }

    @Override
    public void updateStatusTo(Long id, boolean status) {
        userDao.updateStatusTo(id, status);
    }

}
