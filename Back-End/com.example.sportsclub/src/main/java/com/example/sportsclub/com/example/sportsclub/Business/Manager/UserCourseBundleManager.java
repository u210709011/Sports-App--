package com.example.sportsclub.com.example.sportsclub.Business.Manager;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sportsclub.com.example.sportsclub.Business.Interface.IUserCourseBundleService;
import com.example.sportsclub.com.example.sportsclub.DAO.Interface.ICourseBundleDao;
import com.example.sportsclub.com.example.sportsclub.DAO.Interface.IUserCourseBundleDao;
import com.example.sportsclub.com.example.sportsclub.DAO.Interface.IUserDao;
import com.example.sportsclub.com.example.sportsclub.Entity.CourseBundle;
import com.example.sportsclub.com.example.sportsclub.Entity.User;
import com.example.sportsclub.com.example.sportsclub.Entity.UserCourseBundle;

@Service
public class UserCourseBundleManager implements IUserCourseBundleService {

    IUserDao userDao;
    ICourseBundleDao courseBundleDao;
    IUserCourseBundleDao userCourseBundledao;


    

    public UserCourseBundleManager(IUserDao userDao, ICourseBundleDao courseBundleDao,
            IUserCourseBundleDao userCourseBundledao) {
        this.userDao = userDao;
        this.courseBundleDao = courseBundleDao;
        this.userCourseBundledao = userCourseBundledao;
    }

    @Override
    public List<UserCourseBundle> getAll() {
        return userCourseBundledao.getAll();
    }

    @Override
    public void add(Long userId, Long courseBundleId) {
        User user = userDao.getById(userId);
        CourseBundle courseBundle = courseBundleDao.getById(courseBundleId);

        UserCourseBundle userCourseBundle = new UserCourseBundle();
        userCourseBundle.setUser(user);
        userCourseBundle.setCourseBundle(courseBundle);
        userCourseBundle.setRemainingDays(courseBundle.getCourse_duration_days());

        userCourseBundledao.add(userCourseBundle);
    }

    @Override
    public void decrementRemainingDays(Long userCourseBundleId) {
        UserCourseBundle userCourseBundle = userCourseBundledao.getById(userCourseBundleId);
        userCourseBundle.setRemainingDays(userCourseBundle.getRemainingDays() - 1);
        userCourseBundledao.update(userCourseBundle);
    }

    @Override
    public void update(UserCourseBundle usercourseBundle) {
        userCourseBundledao.update(usercourseBundle);
    }

    @Override
    public void delete(Long userId, Long courseBundleId) {
        userCourseBundledao.delete(userId, courseBundleId);
    }

    @Override
    public UserCourseBundle getById(Long id) {
        return userCourseBundledao.getById(id);
    }
    
}
