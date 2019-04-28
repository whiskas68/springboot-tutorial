package demo4.proxy;


import demo4.Impl.RobotDelegate;
import demo4.Irobot;
import demo4.RealRobot;

import java.lang.reflect.Proxy;

public class DynamicProxy {

    public static Irobot enhanceRobot(Irobot target){
        return (Irobot) Proxy.newProxyInstance(
                DynamicProxy.class.getClassLoader(),
                new Class<?>[]{Irobot.class},
                new RobotDelegate(target)
        );
    }

    public static void main(String[] args){
        Irobot robot = enhanceRobot(new RealRobot());
        robot.say("world");
    }
}
