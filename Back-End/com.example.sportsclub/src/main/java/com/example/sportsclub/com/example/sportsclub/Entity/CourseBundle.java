package com.example.sportsclub.com.example.sportsclub.Entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course_bundle")
public class CourseBundle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_name", unique = true, nullable = false)
    private String course_name;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "course_duration_days", nullable = false)
    private int course_duration_days;

    @JsonIgnore
    @OneToMany(mappedBy = "courseBundle", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserCourseBundle> userCourseBundles = new ArrayList<>();

}
