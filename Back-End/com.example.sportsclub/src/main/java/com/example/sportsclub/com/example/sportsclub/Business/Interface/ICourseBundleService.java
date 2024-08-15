package com.example.sportsclub.com.example.sportsclub.Business.Interface;

import java.util.List;

import com.example.sportsclub.com.example.sportsclub.Entity.CourseBundle;

public interface ICourseBundleService {
    List<CourseBundle> getAll();

    void add(CourseBundle courseBundle);

    void update(CourseBundle courseBundle);

    void delete(CourseBundle courseBundle);

    CourseBundle getById(Long id);
}
