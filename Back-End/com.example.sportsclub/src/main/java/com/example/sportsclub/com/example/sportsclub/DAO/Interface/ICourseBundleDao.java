package com.example.sportsclub.com.example.sportsclub.DAO.Interface;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.sportsclub.com.example.sportsclub.Entity.CourseBundle;

@Repository
public interface ICourseBundleDao {

    List<CourseBundle> getAll();

    void add(CourseBundle courseBundle);

    void update(CourseBundle courseBundle);

    void delete(CourseBundle courseBundle);

    CourseBundle getById(Long id);
    
}
