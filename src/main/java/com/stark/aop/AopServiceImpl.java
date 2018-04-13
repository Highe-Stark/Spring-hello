package com.stark.aop;

import javax.security.auth.login.AccountException;

public class AopServiceImpl implements IAopService{
    private String name;
    public void withAop() throws Exception {
        System.out.println("Running withAop function. Name: " + name);
        if (name.trim().length() == 0) {
            throw new AccountException("name attribute can't be Null");
        }
    }

    public void withoutAop() throws Exception {
        System.out.println("Function withoutAop running");
    }

    public String getName() {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }
}
