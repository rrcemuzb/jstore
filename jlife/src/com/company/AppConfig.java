package com.company;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;

@Configuration
@ComponentScan("com.company")
public class AppConfig {

    @Bean(name = "thymeleaf")
    public Renderer getRenderer() {
        return new Renderer();
    }

    ;

}
