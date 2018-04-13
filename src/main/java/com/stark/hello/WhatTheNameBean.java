package com.stark.hello;

import org.springframework.beans.factory.BeanNameAware;

public class WhatTheNameBean implements BeanNameAware {
    private String beanName;

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
}
