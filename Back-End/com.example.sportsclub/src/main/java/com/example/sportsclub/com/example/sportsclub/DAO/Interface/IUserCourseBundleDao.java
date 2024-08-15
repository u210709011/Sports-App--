package com.example.sportsclub.com.example.sportsclub.DAO.Interface;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.sportsclub.com.example.sportsclub.Entity.UserCourseBundle;

@Repository
public interface IUserCourseBundleDao {

    List<UserCourseBundle> getAll();

    void add(UserCourseBundle courseBundle);

    void update(UserCourseBundle courseBundle);

    void delete(Long userId, Long courseBundleId);

    UserCourseBundle getById(Long id);

}
