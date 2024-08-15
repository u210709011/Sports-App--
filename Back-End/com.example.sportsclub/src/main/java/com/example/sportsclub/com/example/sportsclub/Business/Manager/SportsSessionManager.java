package com.example.sportsclub.com.example.sportsclub.Business.Manager;

import java.util.List;
import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.example.sportsclub.com.example.sportsclub.Business.Interface.ISportsSessionService;
import com.example.sportsclub.com.example.sportsclub.DAO.Interface.ISportsSessionDao;
import com.example.sportsclub.com.example.sportsclub.DAO.Interface.IUserCourseBundleDao;
import com.example.sportsclub.com.example.sportsclub.DAO.Interface.IUserDao;
import com.example.sportsclub.com.example.sportsclub.Entity.SportsSession;
import com.example.sportsclub.com.example.sportsclub.Entity.User;
import com.example.sportsclub.com.example.sportsclub.Entity.UserCourseBundle;

@Service
public class SportsSessionManager implements ISportsSessionService {

    IUserCourseBundleDao userCourseBundledao;

    IUserDao userDao;

    ISportsSessionDao sportsSessionDao;

    public SportsSessionManager(IUserCourseBundleDao userCourseBundledao, IUserDao userDao, ISportsSessionDao sportsSessionDao) {
        this.userCourseBundledao = userCourseBundledao;
        this.userDao = userDao;
        this.sportsSessionDao = sportsSessionDao;
    }

    @Override
    public List<SportsSession> getAll() {
        return sportsSessionDao.getAll();
    }

    @Override
    public void add(Long userId, Long userCourseBundleId, LocalDate localDate) {
        User user = userDao.getById(userId);
        UserCourseBundle userCourseBundle = userCourseBundledao.getById(userCourseBundleId);
        SportsSession sportsSession= new SportsSession();
        sportsSession.setUser(user);
        sportsSession.setUserCourseBundle(userCourseBundle);
        sportsSession.setDate(localDate);
        sportsSessionDao.add(sportsSession);
    }

    @Override
    public void update(SportsSession sportsSession) {
        sportsSessionDao.update(sportsSession);
    }

    @Override
    public void delete(Long id) {
        sportsSessionDao.delete(id);
    }

    @Override
    public SportsSession getById(Long id) {
        return sportsSessionDao.getById(id);
    }
    
}
