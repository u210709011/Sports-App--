package com.example.sportsclub.com.example.sportsclub.DAO.Hibernate;

import java.util.List;

import org.hibernate.Session;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.sportsclub.com.example.sportsclub.DAO.Interface.IUserDao;
import com.example.sportsclub.com.example.sportsclub.Entity.User;

import jakarta.persistence.EntityManager;

@Repository
public class HibernateUserDao implements IUserDao {

    private EntityManager entityManager;

    public HibernateUserDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<User> getAll() {
        Session session = entityManager.unwrap(Session.class);
        List<User> users = session.createQuery("from User", User.class).getResultList();
        return users;
    }

    @Override
    @Transactional
    public void add(User user) {
        Session session = entityManager.unwrap(Session.class);
        session.persist(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        Session session = entityManager.unwrap(Session.class);
        session.merge(user);
    }

    @Override
    @Transactional
    public void delete(User user) {
        Session session = entityManager.unwrap(Session.class);
        User userToDelete = session.get(User.class, user.getId());
        session.remove(userToDelete);
    }

    @Override
    @Transactional
    public User getById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        User user = session.get(User.class, id);
        return user;
    }

    @Override
    @Transactional
    public User getByUsername(String username) {
        Session session = entityManager.unwrap(Session.class);
        User user = session.createQuery("from User where username = :username", User.class).setParameter("username", username).getSingleResultOrNull();
        return user;    
    }

    @Override
    @Transactional
    public List<User> getAllByRole(String role) {
        Session session = entityManager.unwrap(Session.class);
        List<User> user = session.createQuery("from User where role = :role", User.class).setParameter("role", role).getResultList();
        return user;  
    }

    @Override
    @Transactional
    public User getByEmail(String email) {
        Session session = entityManager.unwrap(Session.class);
        User user = session.createQuery("from User where email = :email", User.class).setParameter("email", email).getSingleResultOrNull();
        return user;  
    }

    @Override
    @Transactional
    public boolean login(String username, String password) {
        Session session = entityManager.unwrap(Session.class);
        User user = session.createQuery("from User where username = :username and password = :password", User.class).setParameter("username", username).setParameter("password", password).getSingleResultOrNull();
        return user != null && user.getPassword().equals(password);
    }

    @Override
    @Transactional
    public boolean isAdmin(String username) {
        Session session = entityManager.unwrap(Session.class);
        User user = session.createQuery("from User where username = :username and role = :role", User.class).setParameter("username", username).setParameter("role", "ADMIN").getSingleResultOrNull();
        return user != null;
    }

    @Override
    @Transactional
    @Modifying
    public void updateAllUsersStatusToFalse() {
        Session session = entityManager.unwrap(Session.class);
        session.createQuery("update User u set u.status = false", User.class);
    }

    @Override
    @Transactional
    public void updateStatusTo(Long id, boolean status) {
        Session session = entityManager.unwrap(Session.class);
        User user = session.get(User.class, id);
        user.setStatus(status);
        
    }

    



}
