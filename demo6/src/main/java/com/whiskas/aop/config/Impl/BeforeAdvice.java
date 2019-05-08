package com.whiskas.aop.config.Impl;

import com.whiskas.aop.config.Advice;
import com.whiskas.aop.config.MethodIncocation;

import java.lang.reflect.Method;

public class BeforeAdvice implements Advice {

    private Object bean;

    private MethodIncocation methodIncocation;

    public BeforeAdvice(Object bean, MethodIncocation methodIncocation){
        this.bean = bean;
        this.methodIncocation = methodIncocation;
    }

    @Override
    public Object invoke(Object proxy, Method method,Object[] args) throws  Throwable{
        //在执行前调用
        methodIncocation.invoke();
        return method.invoke(bean,args);
    }

}
