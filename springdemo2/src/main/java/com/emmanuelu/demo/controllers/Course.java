package com.emmanuelu.demo.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Course {
	
	@RequestMapping("m/{track}/{mode}/{less}")
    public String showLesson(@PathVariable("track") String track2, 
    		@PathVariable("module") String mod, 
        @PathVariable("lesson") String lesson){
        return "Track: " + track2 + ", Module: " + mod + ", Lesson: " + lesson;
    }

}
