package com.example.sportsclub.com.example.sportsclub.Business.Manager;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sportsclub.com.example.sportsclub.Business.Interface.ICourseBundleService;
import com.example.sportsclub.com.example.sportsclub.DAO.Interface.ICourseBundleDao;
import com.example.sportsclub.com.example.sportsclub.Entity.CourseBundle;
import java.util.List;

@Service
public class CourseBundleManager implements ICourseBundleService {
    ICourseBundleDao courseBundleDao;

    public CourseBundleManager(ICourseBundleDao courseBundleDao) {
        this.courseBundleDao = courseBundleDao;
    }

    @Override
    @Transactional
    public List<CourseBundle> getAll() {
        return courseBundleDao.getAll();
    }

    @Override
    @Transactional
    public void add(CourseBundle courseBundle) {
        this.courseBundleDao.add(courseBundle);
    }

    @Override
    @Transactional
    public void update(CourseBundle courseBundle) {
        this.courseBundleDao.update(courseBundle);
    }

    @Override
    @Transactional
    public void delete(CourseBundle courseBundle) {
        this.courseBundleDao.delete(courseBundle);
    }

    @Override
    @Transactional
    public CourseBundle getById(Long id) {
        return this.courseBundleDao.getById(id);
    }

}
