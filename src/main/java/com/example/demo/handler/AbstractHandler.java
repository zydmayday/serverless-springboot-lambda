package com.example.demo.handler;

import com.example.demo.config.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public abstract class AbstractHandler {
    protected  ApplicationContext applicationContext;

    protected AbstractHandler() {
        applicationContext = new AnnotationConfigApplicationContext(Config.class);
    }
}
