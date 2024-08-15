package com.example.sportsclub.com.example.sportsclub.DAO.Interface;

import org.springframework.stereotype.Repository;

import com.example.sportsclub.com.example.sportsclub.Entity.SportsSession;
import java.util.List;

@Repository
public interface ISportsSessionDao {

    List<SportsSession> getAll();

    void add(SportsSession session);

    void update(SportsSession session);

    void delete(Long id);

    SportsSession getById(Long id);

}
