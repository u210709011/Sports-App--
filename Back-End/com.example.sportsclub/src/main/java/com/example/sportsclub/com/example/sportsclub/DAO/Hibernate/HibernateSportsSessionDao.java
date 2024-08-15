package com.example.sportsclub.com.example.sportsclub.DAO.Hibernate;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.sportsclub.com.example.sportsclub.DAO.Interface.ISportsSessionDao;
import com.example.sportsclub.com.example.sportsclub.Entity.SportsSession;
import jakarta.persistence.EntityManager;

@Repository
public class HibernateSportsSessionDao implements ISportsSessionDao{

    EntityManager entityManager;

    public HibernateSportsSessionDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<SportsSession> getAll() {
        Session session = entityManager.unwrap(Session.class);
        List<SportsSession> userCourseBundle = session.createQuery("from SportsSession", SportsSession.class).getResultList();
        return userCourseBundle;
    }

    @Override
    @Transactional
    public void add(SportsSession userCourseBundle) {
        Session session = entityManager.unwrap(Session.class);
        session.persist(userCourseBundle);
    }

    @Override
    @Transactional
    public void update(SportsSession userCourseBundle) {
        Session session = entityManager.unwrap(Session.class);
        session.merge(userCourseBundle);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Session session = entityManager.unwrap(Session.class);
        SportsSession userCourseBundleToDelete = session.get(SportsSession.class, id);
        session.remove(userCourseBundleToDelete);
    }

    @Override
    @Transactional
    public SportsSession getById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        SportsSession userCourseBundle = session.get(SportsSession.class, id);
        return userCourseBundle;
    }

}
