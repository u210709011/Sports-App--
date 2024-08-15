package com.example.sportsclub.com.example.sportsclub.DAO.Hibernate;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.sportsclub.com.example.sportsclub.DAO.Interface.ICourseBundleDao;
import com.example.sportsclub.com.example.sportsclub.Entity.CourseBundle;

import jakarta.persistence.EntityManager;

@Repository
public class HibernateCourseBundleDao implements ICourseBundleDao {

    private EntityManager entityManager;

    public HibernateCourseBundleDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<CourseBundle> getAll() {
        Session session = entityManager.unwrap(Session.class);
        List<CourseBundle> courseBundle = session.createQuery("from CourseBundle", CourseBundle.class).getResultList();
        return courseBundle;
    }

    @Override
    @Transactional
    public void add(CourseBundle courseBundle) {
        Session session = entityManager.unwrap(Session.class);
        session.persist(courseBundle);
    }

    @Override
    @Transactional
    public void update(CourseBundle courseBundle) {
        Session session = entityManager.unwrap(Session.class);
        session.merge(courseBundle);
    }

    @Override
    @Transactional
    public void delete(CourseBundle courseBundle) {
        Session session = entityManager.unwrap(Session.class);
        CourseBundle courseBundleToDelete = session.get(CourseBundle.class, courseBundle.getId());
        session.remove(courseBundleToDelete);
    }

    @Override
    @Transactional
    public CourseBundle getById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        CourseBundle courseBundle = session.get(CourseBundle.class, id);
        return courseBundle;
    }
    
}
