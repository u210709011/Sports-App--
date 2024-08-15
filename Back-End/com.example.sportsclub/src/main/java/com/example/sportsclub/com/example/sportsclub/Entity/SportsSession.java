package com.example.sportsclub.com.example.sportsclub.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Getter
@ToString
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "session")
public class SportsSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_course_bundle_id")
    private UserCourseBundle userCourseBundle;

    @Column(name = "date", nullable = false)
    private LocalDate date;
    
}
