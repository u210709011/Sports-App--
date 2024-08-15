package com.example.sportsclub.com.example.sportsclub.restApi;

import java.util.List;
import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.sportsclub.com.example.sportsclub.Business.Interface.ISportsSessionService;
import com.example.sportsclub.com.example.sportsclub.Entity.SportsSession;

@RestController
@RequestMapping("/api")
public class SportsSessionController {

    ISportsSessionService sportsSessionService;


    public SportsSessionController(ISportsSessionService sportsSessionService) {
        this.sportsSessionService = sportsSessionService;
    }


    @GetMapping("/sportsSessions")
    public List<SportsSession> getAll() {
        return sportsSessionService.getAll();
    }

    @PostMapping("/users/{userId}/courseBundles/{courseBundleId}/add")
    public void add(@PathVariable Long userId, @PathVariable Long courseBundleId, @RequestParam LocalDate localDate) {
        sportsSessionService.add(userId, courseBundleId, localDate);
    }

    @PostMapping("/sportsSessions/update")
    public void update(@RequestBody SportsSession session) {
        sportsSessionService.update(session);
    }

    @PostMapping("/sportsSessions/{id}/delete")
    public void delete(@PathVariable Long id) {
        sportsSessionService.delete(id);
    }

    @GetMapping("/sportsSessions/{id}")
    public SportsSession getById(@PathVariable Long id) {
        return sportsSessionService.getById(id);
    }
    
}
