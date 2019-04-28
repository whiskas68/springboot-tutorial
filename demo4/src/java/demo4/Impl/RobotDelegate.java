package demo4.Impl;

import demo4.Irobot;
import demo4.RealRobot;
import demo4.proxy.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class RobotDelegate implements InvocationHandler {

    private Irobot target; //需要包装的目标对象

    public RobotDelegate(Irobot target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 在代理目标对象前添加自定义操作
        System.out.println("升级前");

        //通过反射，打印出要调用目标对象的方法
        System.out.println("Method: " + method);

        //代理对象通过"invoke"调用目标对象的方法
        method.invoke(target, args);

        System.out.println("升级后");

        return null;
    }
}
