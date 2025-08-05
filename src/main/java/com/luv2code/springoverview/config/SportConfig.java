package com.luv2code.springoverview.config;

import com.luv2code.springoverview.common.Coach;
import com.luv2code.springoverview.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
