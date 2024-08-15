package com.example.sportsclub.com.example.sportsclub.restApi;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.sportsclub.com.example.sportsclub.Business.Interface.IUserCourseBundleService;
import com.example.sportsclub.com.example.sportsclub.Entity.UserCourseBundle;

@RestController
@RequestMapping("/api")
public class UserCourseBundleController {

    private IUserCourseBundleService userCourseBundleService;

    public UserCourseBundleController(IUserCourseBundleService userCourseBundleService) {
        this.userCourseBundleService = userCourseBundleService;
    }

    @GetMapping("/users/courseBundles")
    public List<UserCourseBundle> getAll() {
        return userCourseBundleService.getAll();
    }

    @PostMapping("/users/{userId}/courseBundles/add")
    public void add(@PathVariable Long userId, @RequestParam Long courseBundleId) {
        userCourseBundleService.add(userId, courseBundleId);
    }

    @PostMapping("/users/courseBundles/update")
    void update(@RequestBody UserCourseBundle userCourseBundle) {
        userCourseBundleService.update(userCourseBundle);
    }

    @PostMapping("/users/{userId}/courseBundles/{courseBundleId}/delete")
    void delete(@PathVariable Long userId, @PathVariable Long courseBundleId) {
        userCourseBundleService.delete(userId, courseBundleId);
    }

    @GetMapping("/users/courseBundles/{id}")
    UserCourseBundle getById(@PathVariable Long id) {
        return userCourseBundleService.getById(id);
    }

    @PostMapping("/users/courseBundles/{userCourseBundleId}/decrement")
    public void decrementRemainingDays(@PathVariable Long userCourseBundleId) {
        userCourseBundleService.decrementRemainingDays(userCourseBundleId);
    }

}