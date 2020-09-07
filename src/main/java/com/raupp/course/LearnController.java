package com.raupp.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RefreshScope
public class LearnController {

    @Autowired
    private courseRepository courseRepository;
    @Value(("${organization.name}"))
    private String organizationName;
    @Value(("${service.welcome.message}"))
    private String welcomeMessage;
    @RequestMapping("/")
    public String getCourseAppHome() {

        return ("Course App Home "+" ********* "+organizationName+" ******* "+welcomeMessage);
    }


    @RequestMapping("/courses")
    public List<Course> getCourses(){
        return courseRepository.findAll();
    }

    @RequestMapping("/{id}")
    public Course getCourseId(@PathVariable("id") BigInteger id){
        return courseRepository.getOne(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/courses")
    public void saveCourse(@RequestBody Course course){
        courseRepository.save(course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public void deleteCourse(@PathVariable("id") BigInteger id){
        courseRepository.deleteById(id);
    }
}
