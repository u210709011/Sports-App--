package com.example.sportsclub.com.example.sportsclub.restApi;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sportsclub.com.example.sportsclub.Business.Interface.ICourseBundleService;
import com.example.sportsclub.com.example.sportsclub.Entity.CourseBundle;


@RestController
@RequestMapping("/api")
public class CourseBundleController {
    private ICourseBundleService courseBundleService;

    public CourseBundleController(ICourseBundleService courseBundleService) {
        this.courseBundleService = courseBundleService;
    }

    @GetMapping("/courseBundles")
    public List<CourseBundle> get() {
        return courseBundleService.getAll();
    }

    @PostMapping("/courseBundles/add")
    public void add(@RequestBody CourseBundle courseBundle) {
        courseBundleService.add(courseBundle);
    }

    @PostMapping("/courseBundles/update")
    public void update(@RequestBody CourseBundle courseBundle) {
        courseBundleService.update(courseBundle);
    }

    @PostMapping("/courseBundles/delete")
    public void delete(@RequestBody CourseBundle courseBundle) {
        courseBundleService.delete(courseBundle);
    }

    @GetMapping("/courseBundles/{id}")
    public CourseBundle getById(@PathVariable Long id) {
        return courseBundleService.getById(id);
    }

}
