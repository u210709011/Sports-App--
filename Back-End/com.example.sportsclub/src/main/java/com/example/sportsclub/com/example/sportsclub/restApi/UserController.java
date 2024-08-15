package com.example.sportsclub.com.example.sportsclub.restApi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.example.sportsclub.com.example.sportsclub.Business.Interface.IUserService;
import com.example.sportsclub.com.example.sportsclub.Entity.User;

@RestController
@RequestMapping(value = "/api")
public class UserController {
    private IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> get() {
        return userService.getAll();
    }

    @PostMapping("/users/add")
    public void add(@RequestBody User user) {
        userService.add(user);
    }

    @PostMapping("/users/update")
    public void update(@RequestBody User user) {
        userService.update(user);
    }

    @PostMapping("/users/delete")
    public void delete(@RequestBody User user) {
        userService.delete(user);
    }

    @GetMapping("/users/{id}")
    public User getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @GetMapping("/users/username/{username}")
    public User getByUsername(@PathVariable String username) {
        return userService.getByUsername(username);
    }

    @GetMapping("/users/email/{email}")
    public User getByEmail(@PathVariable String email) {
        return userService.getByEmail(email);
    }

    @GetMapping("/users/role/{role}")
    public List<User> getAllByRole(@PathVariable String role) {
        return userService.getAllByRole(role);
    }

    @GetMapping("/login")
    public boolean login(@RequestParam String username, @RequestParam String password) {
        return userService.login(username,password);
    }

    @GetMapping("/isAdmin")
    public boolean isAdmin(@RequestParam String username) {
        return userService.isAdmin(username);
    }

    @PostMapping("/users/{id}/status/{status}")
    public void postMethodName(@PathVariable Long id,@PathVariable boolean status) {
        userService.updateStatusTo(id, status);
    }
    
    
    

    

}
