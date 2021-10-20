package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class AppContext {

    @Autowired
    private ApplicationContext applicationContext;

    public <T> T getBean(Class<T> tClass) {
        return applicationContext.getBean(tClass);
    }
}
