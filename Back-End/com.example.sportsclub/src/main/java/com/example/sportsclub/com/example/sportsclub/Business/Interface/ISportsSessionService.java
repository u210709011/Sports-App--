package com.example.sportsclub.com.example.sportsclub.Business.Interface;

import java.time.LocalDate;
import java.util.List;
import com.example.sportsclub.com.example.sportsclub.Entity.SportsSession;

public interface ISportsSessionService {

    List<SportsSession> getAll();

    void add(Long userId, Long courseBundleId, LocalDate localDate);

    void update(SportsSession sportsSession);

    void delete(Long id);

    SportsSession getById(Long id);
}
