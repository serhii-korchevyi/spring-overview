package com.luv2code.springoverview.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {

    public BaseballCoach() {
        System.out.println("BaseballCoach constructor");
    }

    @Override
    public String getDailyWorkout() {
        return "Send 30 minutes in batting practice";
    }
}
