package com.luv2code.springoverview.rest;

import com.luv2code.springoverview.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoController {

    private Coach coach;

    @Autowired
    public DemoController(
            @Qualifier("aquatic") Coach coach
    ) {
        System.out.println("Initializing DemoController...");
        this.coach = coach;
    }

    /*@Autowired
    public void setCoach(Coach coach) {
        this.coach = coach;
    }*/

    @GetMapping("/getDailyWorkout")
    public String getDailyWorkout() {
        return  coach.getDailyWorkout();
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
}
