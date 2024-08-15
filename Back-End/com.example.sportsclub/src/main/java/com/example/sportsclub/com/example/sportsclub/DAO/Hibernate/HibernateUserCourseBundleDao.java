package com.example.sportsclub.com.example.sportsclub.DAO.Hibernate;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.sportsclub.com.example.sportsclub.DAO.Interface.IUserCourseBundleDao;
import com.example.sportsclub.com.example.sportsclub.Entity.UserCourseBundle;

import jakarta.persistence.EntityManager;

@Repository
public class HibernateUserCourseBundleDao implements IUserCourseBundleDao {

    private EntityManager entityManager;

    public HibernateUserCourseBundleDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<UserCourseBundle> getAll() {
        Session session = entityManager.unwrap(Session.class);
        List<UserCourseBundle> userCourseBundle = session.createQuery("from UserCourseBundle", UserCourseBundle.class)
                .getResultList();
        return userCourseBundle;
    }

    @Override
    @Transactional
    public void add(UserCourseBundle userCourseBundle) {
        Session session = entityManager.unwrap(Session.class);
        session.persist(userCourseBundle);
    }

    @Override
    @Transactional
    public void update(UserCourseBundle userCourseBundle) {
        Session session = entityManager.unwrap(Session.class);

        // Retrieve the existing entity from the database using the provided ID
        UserCourseBundle existingUserCourseBundle = session.get(UserCourseBundle.class, userCourseBundle.getId());

        if (existingUserCourseBundle != null) {
            // Update the remaining days field directly on the managed entity
            existingUserCourseBundle.setRemainingDays(userCourseBundle.getRemainingDays());

            // No need to call merge(); the changes will be automatically persisted
        } else {
            throw new RuntimeException("UserCourseBundle not found with id: " + userCourseBundle.getId());
        }
    }

    @Override
    @Transactional
    public void delete(Long userId, Long courseBundleId) {
        Session session = entityManager.unwrap(Session.class);
        UserCourseBundle userCourseBundle = session.get(UserCourseBundle.class, courseBundleId);
        session.remove(userCourseBundle);
    }

    @Override
    @Transactional
    public UserCourseBundle getById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        UserCourseBundle userCourseBundle = session.get(UserCourseBundle.class, id);
        return userCourseBundle;
    }
}
