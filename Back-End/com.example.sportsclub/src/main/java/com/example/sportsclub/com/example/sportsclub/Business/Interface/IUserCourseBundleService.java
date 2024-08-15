package com.example.sportsclub.com.example.sportsclub.Business.Interface;

import java.util.List;

import com.example.sportsclub.com.example.sportsclub.Entity.UserCourseBundle;

public interface IUserCourseBundleService {
    List<UserCourseBundle> getAll();

    void add(Long userId, Long courseBundleId);

    void update(UserCourseBundle userCourseBundle);

    void delete(Long userId, Long courseBundleId);

    UserCourseBundle getById(Long id);

    void decrementRemainingDays(Long userCourseBundleId);
}