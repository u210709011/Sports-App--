package com.example.sportsclub.com.example.sportsclub.Business.Manager;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.sportsclub.com.example.sportsclub.Business.Interface.IUserStatusService;
import com.example.sportsclub.com.example.sportsclub.DAO.Interface.IUserDao;

@Service
public class UserStatusManager implements IUserStatusService {

    private IUserDao userDao;

    

    public UserStatusManager(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Scheduled(cron = "0 0 0 * * * ")
    public void resetUserStatus() {
        userDao.updateAllUsersStatusToFalse();
    }


    

}
