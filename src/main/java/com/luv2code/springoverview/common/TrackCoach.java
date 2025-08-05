package com.luv2code.springoverview.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {

    public TrackCoach() {
        System.out.println("TrackCoach constructor");
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }
}
