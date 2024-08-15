package com.example.sportsclub.com.example.sportsclub.Entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UserCourseBundle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @ManyToOne
    @JoinColumn(name = "course_bundle_id")
    private CourseBundle courseBundle;
    
    @OneToMany(mappedBy = "userCourseBundle", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SportsSession> sessions = new ArrayList<>();

    @Column(name = "remainingDays")
    private int remainingDays;
}
