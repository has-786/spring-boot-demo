package com.example.demo.config;

public class BeanFactory {
    private static final BeanFactory instance = new BeanFactory();

    private BeanFactory() {
    }

    public static BeanFactory getInstance() {
        return instance;
    }

    private AppContext context;

    public <T> T getBean(Class<T> tClass) {
        return context.getBean(tClass);
    }

    public void addContext(AppContext context) {
        this.context = context;
    }

}
