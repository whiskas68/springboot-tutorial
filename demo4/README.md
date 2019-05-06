###### 动态代理：
1. InvocationHandler 接口是proxy代理实例去调用或加强目标对象程序实现的一个接口；当目标对象调用方法时，代理实例将该方法分派到加强的处理程序invoke方法中
```java
public interface InvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args)  throws Throwable;
}
```

2. proxy类，提供一个newProxyInstance方法，用来创建一个代理对象。
```java
public static Object newProxyInstance(
ClassLoader loader,                                      
Class<?>[] interfaces,                                      
InvocationHandler h)
```
该方法接收三个参数，
1. loader: 加载定义代理类
2. interface: 提供一组目标接口给代理类实现
3. h: 一个调用处理对象，当代理对象调用方法的时候，由关联到的invocationHandler对象，并由其调用

* 创建一个接口Irobot，并声明一个方法say。
```java
public interface Irobot {     
    void say(String str);
}
```
* 创建一个实现类RealRobot
```java
public class RealRobot implements Irobot {
    public void say(String str){
        System.out.println("hello " + str);
    }
}
```

* 创建一个调用处理类RobotDelegate
```java
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
```

* 创建一个代理类DynamicProxy
```java
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
```
输出结果：
```shell
升级前
Method: public abstract void demo4.Irobot.say(java.lang.String)
hello world
升级后
```

在DynamicProxy类中，我们调用了Proxy.newProxyInstance，生成一个代理类enhanceRobot实例，并持有RobotDelegate实例的引用，当调用代理类实例的方法时，它会将调用逻辑委托给RobotDelegate实例的invoke方法，由于RobotDelegate内部持有目标对象RealRobot的引用，因此可以在invoke方法中添加逻辑对原有方法进行增强。



