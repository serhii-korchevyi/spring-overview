package com.luv2code.springoverview.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    public TennisCoach() {
        System.out.println("TennisCoach constructor");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }
}
